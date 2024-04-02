package future

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.{ExecutionContext, Future}

object Task {
  type Task[A] = ExecutionContext => Future[A]

  implicit class TaskOps[A](fa: Task[A]) {
    def map[B](f: A => B): Task[B] =
      ec => fa(ec).map(f)(ec)

    def flatMap[B](f: A => Task[B]): Task[B] =
      ec => fa(ec).flatMap(f(_)(ec))(ec)

    def future(implicit ec: ExecutionContext): Future[A] =
      fa(ec)
  }

  def fromFuture[A](f: ExecutionContext => Future[A]): Task[A] = f

  def unit[A](a: A): Task[A] = _ => Future.successful(a)

  def sleep(d: FiniteDuration): Task[Unit] =
    _ => Future.successful { Thread.sleep(d.toMillis) }

  val now: Task[FiniteDuration] =
    _ => Future.successful { FiniteDuration(System.currentTimeMillis, TimeUnit.MILLISECONDS) }

  def traverse[A, B](xs: List[Task[A]])(f: A => Task[B]): Task[List[B]] =
    xs.foldLeft(unit(List.empty[B])) { (acc, fa) =>
      for {
        bs <- acc
        a  <- fa
        b  <- f(a)
      } yield b :: bs
    }.map(_.reverse)

  def parTraverse[A, B](n: Int)(xs: List[Task[A]])(f: A => Task[B]): Task[List[B]] =
    xs.grouped(n).foldLeft(unit(List.empty[B])) { (acc, chunk) =>
      for {
        l <- acc
        r <- Task.fromFuture { implicit ec =>
          Future.sequence(chunk.map(_.flatMap(f).future))
        }
      } yield l ++ r
    }

}

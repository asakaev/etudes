package future

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

  def unit[A](a: A): Task[A] =
    _ => Future.successful(a)

  def traverse[A, B](xs: List[Task[A]])(f: A => Task[B]): Task[List[B]] = {
    def go(xs: List[Task[A]], acc: Task[List[B]]): Task[List[B]] = xs match {
      case Nil => acc
      case h :: tl =>
        val acc1 = for {
          ys <- acc
          a  <- h
          b  <- f(a)
        } yield b :: ys

        go(tl, acc1)
    }
    go(xs, unit(Nil)).map(_.reverse)
  }

}

package future

import scala.concurrent.{ ExecutionContext, Future }
import scala.util.control.NonFatal

/**
 * На вход `Seq[Future[String]]`
 * Получить `Future[(Seq[String], Seq[Throwable])]` — результат агрегации выполненых Future и исключений
 */
object Traverse {

  def foldUnzip[A](fs: Seq[Future[A]])(implicit ec: ExecutionContext): Future[(Seq[A], Seq[Throwable])] =
    Future
      .foldLeft(fs.map {
        _.map(Right(_)).recover { case NonFatal(t) => Left(t) }
      }.toList)(List.empty[A] -> List.empty[Throwable]) {
        case ((as, es), Left(e))  => as        -> (e +: es)
        case ((as, es), Right(a)) => (a +: as) -> es
      }
      .map { case (as, es) => as.reverse -> es.reverse }

  def foldUnzipPar[A](fs: Seq[Future[A]])(implicit ec: ExecutionContext): Future[(Seq[A], Seq[Throwable])] =
    Future
      .traverse(fs) {
        _.map(Right(_)).recover { case NonFatal(t) => Left(t) }
      }
      .map {
        _.foldLeft(List.empty[A] -> List.empty[Throwable]) {
          case ((as, es), Left(e))  => as        -> (e +: es)
          case ((as, es), Right(a)) => (a +: as) -> es
        } match { case (as, es) => as.reverse -> es.reverse }
      }

}

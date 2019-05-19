package sequence

import cats.Eq
import fs2.{ Pipe, Pure }

import scala.annotation.tailrec

/**
 * Дана последовательность целочисленных значений.
 * Определить количество смен знака.
 */
object Changes {

  implicit val signEqForInt: Eq[Int] = _.signum == _.signum

  def changes[A: Eq](xs: List[A]): Int = {
    @tailrec def go(n: Int, ys: List[A]): Int = ys match {
      case Nil                              => n
      case _ :: Nil                         => n
      case a :: b :: tl if Eq[A].neqv(a, b) => go(n + 1, b :: tl)
      case _ :: b :: tl                     => go(n, b :: tl)
    }
    go(0, xs)
  }

  def changes2[A: Eq](xs: List[A]): Int = xs match {
    case Nil      => 0
    case _ :: Nil => 0
    case ys =>
      ys.zip(ys.tail).foldLeft(0) {
        case (n, (a, b)) if Eq[A].neqv(a, b) => n + 1
        case (n, _)                          => n
      }
  }

  def changes3[A: Eq](xs: List[A]): Int = xs match {
    case Nil      => 0
    case _ :: Nil => 0
    case ys       => ys.zip(ys.tail).count { case (a, b) => Eq[A].neqv(a, b) }
  }

  def changesPipe[A: Eq]: Pipe[Pure, A, Int] =
    _.zipWithNext.fold(0) {
      case (n, (a, Some(b))) if Eq[A].neqv(a, b) => n + 1
      case (n, _)                                => n
    }

}

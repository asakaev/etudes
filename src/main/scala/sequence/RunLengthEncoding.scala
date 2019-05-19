package sequence

import cats.Eq
import fs2._

import scala.annotation.tailrec

object RunLengthEncoding {

  def rle(in: String): String = {
    @tailrec def go[A](n: Int, xs: List[A], ys: List[(A, Int)]): List[(A, Int)] = xs match {
      case Nil                    => Nil
      case a :: Nil               => a -> n :: ys
      case a :: b :: tl if a == b => go(n + 1, b :: tl, ys)
      case a :: b :: tl           => go(1, b :: tl, a -> n :: ys)
    }

    go(1, in.toList, Nil).reverse.map {
      case (a, n) if n > 1 => s"$a$n"
      case (a, _)          => s"$a"
    }.mkString
  }

  implicit val eqForChar: Eq[Char] = _ == _

  def rlePipe[A: Eq]: Pipe[Pure, A, String] =
    _.zipWithNext
      .mapAccumulate(1) {
        case (n, (a, None))                       => 0     -> Some(a -> n)
        case (n, (a, Some(b))) if Eq[A].eqv(a, b) => n + 1 -> None
        case (n, (a, _))                          => 1     -> Some(a -> n)
      }
      .collect {
        case (_, Some((a, n))) if n > 1 => s"$a$n"
        case (_, Some((a, _)))          => s"$a"
      }

}

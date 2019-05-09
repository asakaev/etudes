package sorting

import scala.annotation.tailrec

object BubbleSort {

  case class S1[A](l: List[A], r: List[A], modified: Boolean)
  case class S2[A](l: List[A], r: List[A])

  /**
   * Returns partially desc ordered list
   * Large values are heavier and therefore sink to the head of list
   * Right if there was swaps, Left otherwise
   *
   * Example:
   * sweep(List(5, 1, 4, 2, 8)) == Right(List(8, 5, 2, 4, 1))
   */
  def sweep[A: Ordering](xs: List[A]): Either[List[A], List[A]] = {
    @tailrec def loop(s: S1[A]): S1[A] = s match {
      case S1(Nil, _, _)                                 => s
      case S1(h :: Nil, r, _)                            => s.copy(Nil, h :: r)
      case S1(a :: b :: t, r, _) if Ordering[A].gt(a, b) => loop(s.copy(a :: t, b :: r, modified = true))
      case S1(a :: b :: t, r, _)                         => loop(s.copy(b :: t, a :: r))
    }
    val s = loop(S1(xs, Nil, modified = false))
    if (s.modified) Right(s.r) else Left(s.r)
  }

  /**
   * Tail recursive BubbleSort implementation
   *
   * Example:
   * bubbleSort(List(5, 1, 4, 2, 8)) == List(1, 2, 4, 5, 8)
   */
  def bubbleSort[A: Ordering](xs: List[A]): List[A] = {
    @tailrec def loop(s: S2[A]): S2[A] = s match {
      case S2(Nil, _)      => s
      case S2(h :: Nil, r) => S2(Nil, h :: r)
      case S2(l, r) =>
        sweep(l) match {
          case Right(h :: t) => loop(S2(t, h :: r))
          case _             => S2(Nil, l ++ r)
        }
    }
    loop(S2(xs, Nil)).r
  }

}

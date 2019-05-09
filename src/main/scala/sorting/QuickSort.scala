package sorting

import scala.annotation.tailrec

object QuickSort {

  case class S[A](xs: List[A], l: List[A], h: List[A])

  /**
   * Partition list into two based on head element as pivot
   * Left are elements that lower by value than pivot, right otherwise
   */
  def partition[A: Ordering](xs: List[A]): (List[A], List[A]) = {
    @tailrec def loop(s: S[A]): S[A] = s match {
      case S(Nil, _, _)                                   => s
      case S(p :: Nil, l, _)                              => s.copy(xs = Nil, l = p :: l)
      case S(p :: x :: Nil, l, h) if Ordering[A].gt(x, p) => s.copy(xs = Nil, l = p :: l, h = x :: h)
      case S(p :: x :: Nil, l, h)                         => s.copy(xs = Nil, l = x :: l, h = p :: h)
      case S(p :: x :: tl, _, h) if Ordering[A].gt(x, p)  => loop(s.copy(xs = p :: tl, h = x :: h))
      case S(p :: x :: tl, l, _)                          => loop(s.copy(xs = p :: tl, l = x :: l))
    }
    val s = loop(S(xs, Nil, Nil))
    s.l -> s.h
  }

  /**
   * Non tail recursive QuickSort implementation
   */
  def quickSort[A: Ordering](xs: List[A]): List[A] =
    partition(xs) match {
      case (Nil, Nil) => Nil
      case (l, Nil)   => l
      case (Nil, h)   => h
      case (l, h)     => quickSort(l) ++ quickSort(h)
    }

}

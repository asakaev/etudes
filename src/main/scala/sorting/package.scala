import scala.annotation.tailrec

package object sorting {

  case class S1[A](l: List[A], r: List[A], modified: Boolean)
  case class S2[A](l: List[A], r: List[A])

  /**
   * Returns partially desc ordered list
   * Right if there was swaps, Left otherwise
   *
   * Example:
   * sweep(List(5, 1, 4, 2, 8)) == Right(List(8, 5, 2, 4, 1))
   */
  def sweep[A: Ordering](xs: List[A]): Either[List[A], List[A]] = {
    @tailrec def sweepAux(s: S1[A]): S1[A] = s.l match {
      case Nil                                 => s.copy(Nil, s.r)
      case h :: Nil                            => s.copy(Nil, h :: s.r)
      case a :: b :: t if Ordering[A].gt(a, b) => sweepAux(s.copy(a :: t, b :: s.r, modified = true))
      case a :: b :: t                         => sweepAux(s.copy(b :: t, a :: s.r))
    }
    val s = sweepAux(S1(xs, Nil, modified = false))
    if (s.modified) Right(s.r) else Left(s.r)
  }

  /**
   * Returns asc ordered list
   *
   * Example:
   * sort(List(5, 1, 4, 2, 8)) == List(1, 2, 4, 5, 8)
   */
  def sort[A: Ordering](xs: List[A]): List[A] = {
    @tailrec def sortAux(s: S2[A]): S2[A] = s.l match {
      case Nil      => S2(Nil, s.r)
      case h :: Nil => S2(Nil, h :: s.r)
      case ys =>
        sweep(ys) match {
          case Right(h :: t) => sortAux(S2(t, h :: s.r))
          case _             => S2(Nil, ys ++ s.r)
        }
    }
    sortAux(S2(xs, Nil)).r
  }

}

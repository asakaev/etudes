package sequence

object Maximums {

  def twoMaximums[A: Ordering](xs: List[A]): Option[(A, A)] = {
    val ord: Ordering[A] = implicitly[Ordering[A]].reverse
    xs.foldLeft(List.empty[A]) { (ys, x) =>
      (x :: ys).distinct.sorted(ord).take(2)
    } match {
      case l :: r :: Nil => Some(l -> r)
      case _             => None
    }
  }

}

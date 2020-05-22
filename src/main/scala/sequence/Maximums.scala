package sequence

object Maximums {

  def secondMaximum[A: Ordering](xs: List[A]): Option[A] = {
    val ord: Ordering[A] = implicitly[Ordering[A]].reverse
    xs.foldLeft(List.empty[A]) { (ys, x) =>
      (x :: ys).distinct.sorted(ord).take(2)
    } match {
      case _ :: x :: Nil => Some(x)
      case _             => None
    }
  }

}

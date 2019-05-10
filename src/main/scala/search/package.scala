import scala.annotation.tailrec

package object search {

  /**
   * Returns position of the target value
   * @param xs sorted vector
   */
  def binarySearch[A: Ordering](xs: Vector[A], v: A): Option[Int] = {
    @tailrec def loop(l: Int, r: Int): Option[Int] =
      if (l > r) None
      else {
        val i = (l + r) / 2
        xs(i) match {
          case x if Ordering[A].lt(v, x) => loop(l, r - i - 1)
          case x if Ordering[A].gt(v, x) => loop(l + i + 1, r)
          case _                         => Some(i)
        }
      }
    loop(0, xs.size - 1)
  }

}

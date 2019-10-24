package sequence

import scala.annotation.tailrec

object ListOps {

  def take[A](as: List[A], n: Int): List[A] = {
    @tailrec def go(acc: List[A], as: List[A], n: Int): List[A] =
      as match {
        case Nil              => acc
        case h :: tl if n > 0 => go(h :: acc, tl, n - 1)
        case _                => acc
      }
    go(Nil, as, n).reverse
  }

}

package sequence

import scala.annotation.tailrec

object Grouped {

  def grouped[A](xs: List[A], n: Int): List[List[A]] = {
    @tailrec
    def go(xs: List[A], acc: List[List[A]], chunk: List[A], sz: Int): List[List[A]] =
      xs match {
        case Nil =>
          if (chunk.isEmpty) acc.reverse
          else (chunk.reverse :: acc).reverse
        case h :: tl =>
          if (sz < n) go(tl, acc, h :: chunk, sz + 1)
          else go(tl, chunk.reverse :: acc, List(h), 1)
      }

    go(xs, Nil, Nil, 0)
  }

}

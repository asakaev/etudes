package leetcode

/** Given a binary array nums, return the maximum number of consecutive 1's in the array.
  */
object P485_MaxConsecutiveOnes {

  def maxConsecutive(xs: List[Int]): Int = {
    def go(xs: List[Int], m: Int, n: Int): Int =
      xs match {
        case Nil => m.max(n)
        case h :: tl =>
          if (h == 1) go(tl, m, n + 1)
          else go(tl, m.max(n), 0)
      }

    go(xs, 0, 0)
  }

}

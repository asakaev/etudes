package leetcode

/** Given a binary array nums, you should delete one element from it.
  *
  * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
  * Return 0 if there is no such subarray.
  */
object P1493_LongestSubarray {

  /** xs.size can be computed inside loop
    */
  def subarray(xs: List[Int]): Int = {
    val (_, _, n) = xs.foldLeft((0, 0, 0)) { case ((a, b, n), x) =>
      if (x == 1) (a + 1, b, (a + b + 1).max(n))
      else (0, a, n)
    }
    if (n == xs.size) n - 1 else n
  }

}

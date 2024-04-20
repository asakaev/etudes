package leetcode

object P70_ClimbingStairs {

  def climbStairs(n: Int): Int = {
    def go(a: Int, b: Int, n: Int): Int =
      if (n <= 1) a else go(a + b, a, n - 1)
    go(1, 1, n)
  }

}

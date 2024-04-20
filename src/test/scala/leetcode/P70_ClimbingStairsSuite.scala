package leetcode

import leetcode.P70_ClimbingStairs.climbStairs
import org.scalatest.funsuite.AnyFunSuite

class P70_ClimbingStairsSuite extends AnyFunSuite {
  test("climbStairs") {
    assert(climbStairs(2) == 2)
    assert(climbStairs(3) == 3)
  }
}

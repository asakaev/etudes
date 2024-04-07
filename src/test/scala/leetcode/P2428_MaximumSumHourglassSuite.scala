package leetcode

import leetcode.P2428_MaximumSumHourglass.maxSum
import org.scalatest.funsuite.AnyFunSuite

class P2428_MaximumSumHourglassSuite extends AnyFunSuite {

  test("maxSum 1") {
    val grid = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    assert(maxSum(grid) == 35)
  }

  test("maxSum 2") {
    val grid = Array(
      Array(6, 2, 1, 3),
      Array(4, 2, 1, 5),
      Array(9, 2, 8, 7),
      Array(4, 1, 2, 9)
    )
    assert(maxSum(grid) == 30)
  }

  test("maxSum 3") {
    val grid = Array(
      Array(520626, 685427, 788912, 800638, 717251, 683428),
      Array(23602, 608915, 697585, 957500, 154778, 209236),
      Array(287585, 588801, 818234, 73530, 939116, 252369)
    )
    assert(maxSum(grid) == 5095181)
  }

}

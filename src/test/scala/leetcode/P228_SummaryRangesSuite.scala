package leetcode

import leetcode.P228_SummaryRanges.summaryRanges
import org.scalatest.funsuite.AnyFunSuite

class P228_SummaryRangesSuite extends AnyFunSuite {
  test("summaryRanges") {
    assert(summaryRanges(Array(0, 1, 2, 4, 5, 7)) == List("0->2", "4->5", "7"))
    val expected1 = List("0", "2->4", "6", "8->9")
    assert(summaryRanges(Array(0, 2, 3, 4, 6, 8, 9)) == expected1)

    val data      = Array(-2147483648, -2147483647, 2147483647)
    val expected2 = List("-2147483648->-2147483647", "2147483647")
    assert(summaryRanges(data) == expected2)
  }
}

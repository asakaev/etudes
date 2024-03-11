package leetcode

import leetcode.P1493_LongestSubarray._
import org.scalatest.funsuite.AnyFunSuite

class P1493_LongestSubarraySuite extends AnyFunSuite {
  test("subarray") {
    assert(subarray(List(1, 1, 0, 1)) == 3)
    assert(subarray(List(0, 1, 1, 1, 0, 1, 1, 0, 1)) == 5)
    assert(subarray(List(1, 1, 1)) == 2)
  }
}

package leetcode

import leetcode.P485_MaxConsecutiveOnes.maxConsecutive
import org.scalatest.funsuite.AnyFunSuite

class P485_MaxConsecutiveOnesSuite extends AnyFunSuite {
  test("maxConsecutive") {
    assert(maxConsecutive(List(1, 1, 0, 1, 1, 1)) == 3)
    assert(maxConsecutive(List(1, 0, 1, 1, 0, 1)) == 2)
  }
}

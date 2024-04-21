package leetcode

import leetcode.P136_SingleNumber.singleNumber
import org.scalatest.funsuite.AnyFunSuite

class P136_SingleNumberSuite extends AnyFunSuite {
  test("singleNumber") {
    assert(singleNumber(Array(2, 2, 1)) == 1)
    assert(singleNumber(Array(4, 1, 2, 1, 2)) == 4)
    assert(singleNumber(Array(1)) == 1)
  }
}

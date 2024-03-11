package leetcode

import leetcode.P1790_OneStringSwap._
import org.scalatest.funsuite.AnyFunSuite

class P1790_OneStringSwapSuite extends AnyFunSuite {
  test("areAlmostEqual") {
    assert(areAlmostEqual("bank", "kanb"))
    assert(!areAlmostEqual("attack", "defend"))
    assert(areAlmostEqual("kelb", "kelb"))
    assert(!areAlmostEqual("aa", "ac"))
    assert(!areAlmostEqual("aa", "bb"))
  }
}

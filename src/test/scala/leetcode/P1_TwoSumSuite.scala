package leetcode

import leetcode.P1_TwoSum._
import org.scalatest.funsuite.AnyFunSuite

class P1_TwoSumSuite extends AnyFunSuite {

  test("twoSum") {
    assert(twoSum(Vector(2, 7, 11, 15), 9) == (0, 1))
    assert(twoSum(Vector(3, 2, 4), 6) == (1, 2))
    assert(twoSum(Vector(3, 3), 6) == (0, 1))
  }

  test("twoSumStream") {
    assert(twoSumStream(Vector(2, 7, 11, 15), 9) == (0, 1))
    assert(twoSumStream(Vector(3, 2, 4), 6) == (1, 2))
    assert(twoSumStream(Vector(3, 3), 6) == (0, 1))
  }

  test("twoSumImperative") {
    assert(twoSumImperative(Vector(2, 7, 11, 15), 9) == (0, 1))
    assert(twoSumImperative(Vector(3, 2, 4), 6) == (1, 2))
    assert(twoSumImperative(Vector(3, 3), 6) == (0, 1))
  }

  test("twoSumLinear") {
    assert(twoSumLinear(Vector(2, 7, 11, 15), 9) == (0, 1))
    assert(twoSumLinear(Vector(3, 2, 4), 6) == (1, 2))
    assert(twoSumLinear(Vector(3, 3), 6) == (0, 1))
  }
}

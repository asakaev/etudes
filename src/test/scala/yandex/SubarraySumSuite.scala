package yandex

import org.scalatest.funsuite.AnyFunSuite
import yandex.SubarraySum.subarraySum

class SubarraySumSuite extends AnyFunSuite {
  test("subarraySum") {
    assert(subarraySum(List(1, -3, 4, 5), 9) == (2, 4))
    assert(subarraySum(List(1, -20, -3, 30, 5, 4), 7) == (1, 4))
  }
}

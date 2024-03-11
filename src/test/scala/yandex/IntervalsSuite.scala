package yandex

import org.scalatest.funsuite.AnyFunSuite
import yandex.Intervals._

class IntervalsSuite extends AnyFunSuite {
  test("overlapping") {
    assert(overlapping(List((1, 2), (1, 3), (2, 4), (2, 3))) == 3)
    assert(overlapping(List((0, 1), (1, 2), (1, 4))) == 2)
  }
}

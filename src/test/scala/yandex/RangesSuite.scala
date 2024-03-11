package yandex

import org.scalatest.funsuite.AnyFunSuite
import yandex.Ranges._

class RangesSuite extends AnyFunSuite {
  test("ranges") {
    val expected1 = List(Range.Both(0, 5), Range.Both(8, 9), Range.One(11))
    assert(ranges(List(1, 4, 5, 2, 3, 9, 8, 11, 0)).reverse == expected1)

    assert(ranges(List(1, 4, 3, 2)).reverse == List(Range.Both(1, 4)))
    assert(ranges(List(1, 4)).reverse == List(Range.One(1), Range.One(4)))
  }
}

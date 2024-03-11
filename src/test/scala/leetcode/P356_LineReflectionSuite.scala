package leetcode

import leetcode.P356_LineReflection._
import org.scalatest.funsuite.AnyFunSuite

class P356_LineReflectionSuite extends AnyFunSuite {
  test("reflected") {
    assert(reflected(List((1, 1), (3, 1), (7, 1), (9, 1))))
    assert(reflected(List((1, 3), (2, 5), (3, 5), (4, 3))))
    assert(!reflected(List((1, 3), (2, 5), (3, 5), (4, 2))))
    assert(reflected(List((1, 1), (-1, 1))))
    assert(!reflected(List((1, 1), (-1, -1))))
  }

  test("reflected2") {
    assert(reflected2(List((1, 1), (3, 1), (7, 1), (9, 1))))
    assert(reflected2(List((1, 3), (2, 5), (3, 5), (4, 3))))
    assert(!reflected2(List((1, 3), (2, 5), (3, 5), (4, 2))))
    assert(reflected2(List((1, 1), (-1, 1))))
    assert(!reflected2(List((1, 1), (-1, -1))))
  }
}

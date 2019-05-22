package math

import math.Mathematics.{ roots, smallest }
import org.scalatest.FunSuite

class MathematicsSuite extends FunSuite {
  test("smallest") {
    assert(smallest(125) == 100)
    assert(smallest(10) == 10)
    assert(smallest(1) == 0)
  }

  test("roots") {
    assert(roots(10, 20) == 2)
    assert(roots(6000, 7000) == 3)
    assert(roots(2, 2) == 1)
  }
}

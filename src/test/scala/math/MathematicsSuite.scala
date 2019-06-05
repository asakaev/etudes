package math

import math.Mathematics._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class MathematicsSuite extends FunSuite with GeneratorDrivenPropertyChecks {
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

  test("roots empty") {
    assert(roots(17, 20) == 0)
  }

  test("even") {
    forAll { i: Int =>
      assert(even(i) == (i % 2 == 0))
    }
  }
}

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

  test("gcd") {
    assert(gcd(1220, 516) == 4)
    assert(gcd(12, 30) == 6)
    assert(gcd(106, 16) == 2)
    assert(gcd(270, 192) == 6)
  }

  test("lcm") {
    assert(lcm(4, 5) == 20)
    assert(lcm(4, 6) == 12)
    assert(lcm(10, 30) == 30)
    assert(lcm(10, 32) == 160)
  }
}

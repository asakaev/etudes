package cracking

import cracking.ArraysStrings._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class ArraysStringsSuite extends AnyFunSuite with ScalaCheckPropertyChecks {
  test("allUnique") {
    forAll { s: String =>
      assert(allUnique1(s) == allUnique2(s))
    }
  }

  test("reverse") {
    forAll { s: String =>
      assert(reverse(s) == s.reverse)
    }
  }
}

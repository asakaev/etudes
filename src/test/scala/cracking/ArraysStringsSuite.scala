package cracking

import cracking.ArraysStrings._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class ArraysStringsSuite extends FunSuite with GeneratorDrivenPropertyChecks {
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

package leetcode

import leetcode.P125_ValidPalindrome._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class P125_ValidPalindromeSuite extends AnyFunSuite with ScalaCheckPropertyChecks {
  test("isPalindrome") {
    forAll { s: String =>
      assert(isPalindrome(s) == isPalindrome2(s))
    }
  }
}

package leetcode

import leetcode.P20_ValidParentheses.isValid
import org.scalatest.funsuite.AnyFunSuite

class P20_ValidParenthesesSuite extends AnyFunSuite {
  test("isValid") {
    assert(isValid("()"))
    assert(isValid("()[]{}"))
    assert(!isValid("(]"))
    assert(!isValid("["))
  }
}

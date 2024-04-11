package leetcode

import leetcode.P567_PermutationString.checkInclusion
import org.scalatest.funsuite.AnyFunSuite

class P567_PermutationStringSuite extends AnyFunSuite {
  test("checkInclusion") {
    assert(checkInclusion("ab", "eidbaooo"))
    assert(!checkInclusion("ab", "eidboaoo"))
  }
}

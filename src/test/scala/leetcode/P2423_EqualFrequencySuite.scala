package leetcode

import leetcode.P2423_EqualFrequency.equalFrequency
import org.scalatest.funsuite.AnyFunSuite

class P2423_EqualFrequencySuite extends AnyFunSuite {
  test("equalFrequency") {
    assert(equalFrequency("abcc"))
    assert(!equalFrequency("aazz"))
    assert(equalFrequency("bac"))
    assert(equalFrequency("cccaa"))
    assert(!equalFrequency("cbccca"))
    assert(!equalFrequency("ddaccb"))
    assert(equalFrequency("zz"))
    assert(equalFrequency("cccd"))
  }
}

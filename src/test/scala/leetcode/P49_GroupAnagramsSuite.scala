package leetcode

import leetcode.P49_GroupAnagrams.groupAnagrams
import org.scalatest.funsuite.AnyFunSuite

class P49_GroupAnagramsSuite extends AnyFunSuite {
  test("groupAnagrams") {
    val result1   = groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")).map(_.sorted)
    val expected1 = List(List("bat"), List("nat", "tan"), List("ate", "eat", "tea"))
    assert(result1 == expected1)

    assert(groupAnagrams(Array("")) == List(List("")))
    assert(groupAnagrams(Array("a")) == List(List("a")))
  }
}

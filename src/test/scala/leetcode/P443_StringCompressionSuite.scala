package leetcode

import leetcode.P443_StringCompression.rle
import org.scalatest.funsuite.AnyFunSuite

class P443_StringCompressionSuite extends AnyFunSuite {
  test("rle") {
    val expected = "A4B3C2XYZD4E3F3A6B28"
    assert(rle("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB") == expected)
  }
}

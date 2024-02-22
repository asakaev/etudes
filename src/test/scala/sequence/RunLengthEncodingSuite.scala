package sequence

import fs2._
import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import sequence.RunLengthEncoding._

class RunLengthEncodingSuite extends AnyFunSuite with ScalaCheckPropertyChecks {

  test("rle") {
    assert(rle("") == "")
    assert(rle("A") == "A")
    assert(rle("AA") == "A2")
    assert(rle("AB") == "AB")
    assert(rle("AAB") == "A2B")
    assert(rle("ABB") == "AB2")
    assert(
      rle("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB") == "A4B3C2XYZD4E3F3A6B28")
  }

  test("rle stream") {
    forAll(Gen.alphaUpperStr) { s: String =>
      assert(Stream.emits(s).through(rlePipe).compile.toList.mkString == rle(s))
    }
  }

}

package sequence

import fs2._
import org.scalacheck.Gen
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class SequenceSuite extends FunSuite with GeneratorDrivenPropertyChecks {

  test("rle0") {
    assert(rle("") == "")
  }

  test("rle1") {
    assert(rle("A") == "A")
  }

  test("rle2a") {
    assert(rle("AA") == "A2")
  }

  test("rle2b") {
    assert(rle("AB") == "AB")
  }

  test("rle3a") {
    assert(rle("AAB") == "A2B")
  }

  test("rle3b") {
    assert(rle("ABB") == "AB2")
  }

  test("rle") {
    assert(rle("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB") == "A4B3C2XYZD4E3F3A6B28")
  }

  test("rle stream") {
    forAll(Gen.alphaUpperStr) { s: String =>
      assert(Stream.emits(s).through(rlePipe).compile.toList.mkString == rle(s))
    }
  }

}

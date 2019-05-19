package sequence

import fs2._
import org.scalacheck.Gen
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import sequence.RunLengthEncoding._

class RunLengthEncodingSuite extends FunSuite with GeneratorDrivenPropertyChecks {

  test("rle") {
    assert(rle("") == "")
    assert(rle("A") == "A")
    assert(rle("AA") == "A2")
    assert(rle("AB") == "AB")
    assert(rle("AAB") == "A2B")
    assert(rle("ABB") == "AB2")
    assert(rle("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB") == "A4B3C2XYZD4E3F3A6B28")
  }

  test("rle stream") {
    forAll(Gen.alphaUpperStr) { s: String =>
      assert(Stream.emits(s).through(rlePipe).compile.toList.mkString == rle(s))
    }
  }

}

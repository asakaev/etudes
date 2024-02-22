package sequence

import org.scalatest.funsuite.AnyFunSuite
import sequence.RunLengthEncoding2._

class RunLengthEncodingSuite2 extends AnyFunSuite {

  test("rle2") {
    assert(rle(List(1, 2, 2, 3, 4, 3, 3, 3)) == List((1, 1), (2, 2), (3, 1), (4, 1), (3, 3)))
    assert(rle(Nil) == Nil)
    assert(rle(List(1)) == List((1, 1)))
  }

}

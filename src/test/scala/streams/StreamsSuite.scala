package streams

import fs2.Stream
import org.scalatest.funsuite.AnyFunSuite
import streams.Streams.fold

class StreamsSuite extends AnyFunSuite {
  test("fold") {
    assert(fold(Stream(1, 2, 3))(0)(_ + _) == 6)
    assert(fold(Stream(1, 2, 3))(List.empty[Int])((xs, x) => x :: xs) == List(3, 2, 1))
  }
}

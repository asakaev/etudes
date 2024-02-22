package transform

import org.scalatest.funsuite.AnyFunSuite

class TransformSuite extends AnyFunSuite {
  test("fallback") {
    assert(fallback(Some(1), None) == Some(Left(1)))
    assert(fallback(Some(1), Some(2)) == Some(Left(1)))
    assert(fallback(None, Some(2)) == Some(Right(2)))
    assert(fallback(None, None) == None)
  }
}

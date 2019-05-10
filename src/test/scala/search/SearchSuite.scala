package search

import org.scalatest.FunSuite

class SearchSuite extends FunSuite {
  test("binarySearch") {
    assert(binarySearch(Vector.empty[Int], 42) == None)
    assert(binarySearch(Vector(1), 0) == None)
    assert(binarySearch(Vector(1), 2) == None)
    assert(binarySearch(Vector(1, 2, 3), 0) == None)
    assert(binarySearch(Vector(1, 2, 3), 4) == None)
    assert(binarySearch(Vector(1, 2, 3), 1) == Some(0))
    assert(binarySearch(Vector(1, 2, 3), 3) == Some(2))
    assert(binarySearch(Vector(1, 2, 3), -1) == None)
    assert(binarySearch(Vector(1, 2, 3), 4) == None)
  }
}

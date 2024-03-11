package leetcode

import leetcode.P849_DistanceToPerson.maxDistToClosest
import org.scalatest.funsuite.AnyFunSuite

class P849_DistanceToPersonSuite extends AnyFunSuite {
  test("maxDistToClosest") {
    assert(maxDistToClosest(Array(1, 0, 0, 0, 1, 0, 1)) == 2)
    assert(maxDistToClosest(Array(1, 0, 0, 0)) == 3)
    assert(maxDistToClosest(Array(0, 1)) == 1)
    assert(maxDistToClosest(Array(1, 0, 0, 1)) == 1)
  }
}

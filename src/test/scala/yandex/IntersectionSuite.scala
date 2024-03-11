package yandex

import org.scalatest.funsuite.AnyFunSuite
import yandex.Intersection._

class IntersectionSuite extends AnyFunSuite {

  test("intersectionSets") {
    val r = intersectionHash(Vector(1, 2, 3, 2, 0), Vector(5, 1, 2, 7, 3, 2)).sorted
    assert(r == Vector(1, 2, 2, 3))
  }

}

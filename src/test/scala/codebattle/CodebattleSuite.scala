package codebattle

import codebattle.Codebattle._
import org.scalatest.FunSuite

class CodebattleSuite extends FunSuite {

  test("boxesVolume") {
    assert(boxesVolume(List(List(2, 3, 2), List(6, 6, 7), List(1, 2, 1))) == 266)
    assert(boxesVolume(List(List(2, 2, 2), List(2, 1, 1))) == 10)
    assert(boxesVolume(List(List(2, 2, 2))) == 8)
  }

  test("positiveDominant") {
    assert(positiveDominant(List(1, 2, 3, -3, -4)))
    assert(positiveDominant(List(1, 1, 2, 2, 3, 3, -4, -4)))
    assert(!positiveDominant(List(1, -1, -2, -3, -4)))
    assert(!positiveDominant(List(10, 1, -2, -2, -3, -4)))
    assert(!positiveDominant(List(1, 2, 3, -3, -4, -5)))
  }

}

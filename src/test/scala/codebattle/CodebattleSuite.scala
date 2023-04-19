package codebattle

import codebattle.Codebattle._
import org.scalatest.FunSuite

class CodebattleSuite extends FunSuite {

  test("boxesVolume") {
    assert(boxesVolume(List(List(2, 3, 2), List(6, 6, 7), List(1, 2, 1))) == 266)
    assert(boxesVolume(List(List(2, 2, 2), List(2, 1, 1))) == 10)
    assert(boxesVolume(List(List(2, 2, 2))) == 8)
  }

}

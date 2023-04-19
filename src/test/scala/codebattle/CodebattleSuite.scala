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

  test("separateWithComma") {
    assert(separateWithComma(1238592) == "1,238,592")
    assert(separateWithComma(1) == "1")
    assert(separateWithComma(10) == "10")
    assert(separateWithComma(150) == "150")
    assert(separateWithComma(1234) == "1,234")
    assert(separateWithComma(15075) == "15,075")
    assert(separateWithComma(123456) == "123,456")
  }

  test("keyForMinValue") {
    val m = Map("father" -> 2, "detail" -> -7, "morning" -> 3, "damage" -> -7, "powder" -> 5)
    assert(keyForMinValue(m) == List("damage", "detail"))
    assert(keyForMinValue(Map("k" -> 2, "h" -> 3, "j"  -> 1)) == List("j"))
    assert(keyForMinValue(Map("o" -> 0, "z" -> -2, "j" -> 1)) == List("z"))
  }

  test("addTwoNumber") {
    assert(addTwoNumber(12) == 3)
    assert(addTwoNumber(23) == 5)
    assert(addTwoNumber(10) == 1)
    assert(addTwoNumber(99) == 18)
  }

}

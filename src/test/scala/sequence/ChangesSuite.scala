package sequence

import fs2._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import sequence.Changes._

class ChangesSuite extends FunSuite with GeneratorDrivenPropertyChecks {
  test("changes") {
    assert(changes(Nil) == 0)
    assert(changes(List(1)) == 0)
    assert(changes(List(1, 1)) == 0)
    assert(changes(List(-1, 1)) == 1)
    assert(changes(List(1, -1)) == 1)
    assert(changes(List(-1, 0)) == 1)
    assert(changes(List(0, -1)) == 1)
    assert(changes(List(0, 0)) == 0)
    assert(changes(List(1, 1, 1)) == 0)
    assert(changes(List(1, 1, -1)) == 1)
    assert(changes(List(-1, 1, 1)) == 1)
    assert(changes(List(-1, 1, -1)) == 2)
    assert(changes(List(1, -1, 1)) == 2)
  }

  test("changes2") {
    forAll { xs: List[Int] =>
      assert(changes2(xs) == changes(xs))
    }
  }

  test("changes3") {
    forAll { xs: List[Int] =>
      assert(changes3(xs) == changes(xs))
    }
  }

  test("changesPipe") {
    forAll { xs: List[Int] =>
      assert(Stream.emits(xs).through(changesPipe).compile.toList == List(changes(xs)))
    }
  }
}

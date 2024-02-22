package sorting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import sorting.BubbleSort.{bubbleSort, sweep}

class BubbleSortSuite extends AnyFunSuite with ScalaCheckPropertyChecks {
  test("sweep") {
    assert(sweep(List(1, 2, 3)) == Left(List(3, 2, 1)))
    assert(sweep(List(1)) == Left(List(1)))
    assert(sweep[Int](Nil) == Left(Nil))
    assert(sweep(List(2, 1)) == Right(List(2, 1)))
    assert(sweep(List(5, 1, 4, 2, 8)) == Right(List(8, 5, 2, 4, 1)))
  }

  test("sort") {
    forAll { xs: List[Int] =>
      assert(bubbleSort(xs) == xs.sorted)
    }
  }
}

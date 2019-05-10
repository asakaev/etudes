package sorting

import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import sorting.QuickSort.{ partition, quickSort }

class QuickSortSuite extends FunSuite with GeneratorDrivenPropertyChecks {

  test("partition") {
    assert(partition(List.empty[Int]) == Nil      -> Nil)
    assert(partition(List(1)) == List(1)          -> Nil)
    assert(partition(List(1, 2)) == List(1)       -> List(2))
    assert(partition(List(2, 1)) == List(1)       -> List(2))
    assert(partition(List(1, 2, 3)) == List(1)    -> List(3, 2))
    assert(partition(List(3, 2, 1)) == List(1, 2) -> List(3))
  }

  test("quickSort") {
    forAll { xs: List[Int] =>
      assert(quickSort(xs) == xs.sorted)
    }
  }

}

package sequence

import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import sequence.Maximums._

class MaximumsSuite extends FunSuite with GeneratorDrivenPropertyChecks {

  test("twoMaximums") {
    forAll { xs: List[Int] =>
      val expected: Option[(Int, Int)] =
        xs.toSet.toList.sorted.reverse match {
          case l :: r :: _ => Some(l -> r)
          case _           => None
        }

      assert(twoMaximums(xs) == expected)
    }
  }

}

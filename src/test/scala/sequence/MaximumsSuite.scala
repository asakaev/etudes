package sequence

import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import sequence.Maximums._

class MaximumsSuite extends FunSuite with GeneratorDrivenPropertyChecks {

  test("secondMaximum") {
    forAll { xs: List[Int] =>
      val expected: Option[Int] =
        xs.toSet.toList.sorted.reverse match {
          case l :: r :: _ => Some(Math.min(l, r))
          case _           => None
        }

      assert(secondMaximum(xs) == expected)
    }
  }

}

package sequence

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import sequence.Maximums._

class MaximumsSuite extends AnyFunSuite with ScalaCheckPropertyChecks {

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

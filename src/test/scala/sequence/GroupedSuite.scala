package sequence

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import sequence.Grouped._
import sequence.GroupedSuite._

class GroupedSuite extends FunSuite with GeneratorDrivenPropertyChecks {
  test("grouped") {
    forAll(genListInt, genPosInt) { (xs: List[Int], n: Int) =>
      assert(grouped(xs, n) == xs.grouped(n).toList)
    }
  }
}

object GroupedSuite {
  val genListInt: Gen[List[Int]] = Arbitrary.arbitrary[List[Int]]
  val genPosInt: Gen[Int]        = Gen.posNum[Int]
}

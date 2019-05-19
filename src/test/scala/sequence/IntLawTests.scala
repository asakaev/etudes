package sequence

import cats.kernel.laws.discipline.EqTests
import cats.tests.CatsSuite
import org.scalacheck.{ Arbitrary, Gen }
import sequence.Changes._

class IntLawTests extends CatsSuite {
  import IntLawTests._
  checkAll("Int.EqLaws", EqTests(signEqForInt).eqv)
}

object IntLawTests {
  // int overflow workaround
  implicit def arbFunction1[A]: Arbitrary[A => A] =
    Arbitrary(Gen.const(identity))
}

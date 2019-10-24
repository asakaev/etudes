package sequence

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import sequence.ListOps._

object ListOpsSpecification extends Properties("ListOps") {

  property("take") = forAll { (xs: List[Int], n: Int) =>
    take(xs, n) == xs.take(n)
  }

}

package puzzle

import org.scalatest.funsuite.AnyFunSuite
import puzzle.Chain._

class ChainSuite extends AnyFunSuite {
  import ChainSuite._

  test("transformationChain") {
    assert(transformationChain(Seq(t1, t2, t3))(2) == Some(16))
    assert(transformationChain(Seq(t1, t2, t2, t1, t2))(2) == Some(8))
  }
}

object ChainSuite {
  val t1: Transformation[Int] = t => Some(t + t)
  val t2: Transformation[Int] = _ => None
  val t3: Transformation[Int] = t => if (t > 2) Some(t * t) else None
}

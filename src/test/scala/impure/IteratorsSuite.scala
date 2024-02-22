package impure

import impure.Iterators._
import org.scalatest.funsuite.AnyFunSuite

class IteratorsSuite extends AnyFunSuite {

  test("flatten") {
    val sample: Iterator[Any] =
      Iterator(
        "1",
        Iterator(
          "1.1",
          "1.2"
        ),
        "2",
        Iterator(
          Iterator(
            "2.1.1"
          ),
          "2.2"
        )
      )

    val expected = List("1", "1.1", "1.2", "2", "2.1.1", "2.2")

    assert(flatten(sample).toList == expected)
  }

  test("roundRobin") {
    val sample: List[Iterator[Int]] =
      List(
        Iterator(1, 2, 3),
        Iterator(4, 5, 6)
      )

    val expected = List(1, 4, 2, 5, 3, 6)

    assert(roundRobin(sample: _*).toList == expected)
  }

}

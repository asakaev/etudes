package impure

import impure.Iterators.flatten
import org.scalatest.FunSuite

class IteratorsSuite extends FunSuite {

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

}

package sequence

import org.scalatest.FunSuite
import sequence.InsertSpaces._

class InsertSpacesSuite extends FunSuite {
  test("insertSpaces") {
    val dict = Set("this", "is", "awesome", "a", "aw", "awe", "some", "so", "me", "i", "we")

    val expected = List(
      "this is a we so me",
      "this is a we some",
      "this is awe so me",
      "this is awe some",
      "this is awesome"
    )

    assert(insertSpaces(dict, "thisisawesome") == expected)
  }
}

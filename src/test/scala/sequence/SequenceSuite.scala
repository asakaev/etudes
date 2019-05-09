package sequence

import org.scalatest.FunSuite

class SequenceSuite extends FunSuite {
  test("fibonacci") {
    assert(fibonacci(1) == 0)
    assert(fibonacci(2) == 1)
    assert(fibonacci(3) == 1)
    assert(fibonacci(4) == 2)
    assert(fibonacci(5) == 3)
  }
}

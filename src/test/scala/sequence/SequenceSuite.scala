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

  test("fibonacci stream") {
    assert(fibonacci.take(1).compile.last == Some(0))
    assert(fibonacci.take(2).compile.last == Some(1))
    assert(fibonacci.take(3).compile.last == Some(1))
    assert(fibonacci.take(4).compile.last == Some(2))
    assert(fibonacci.take(5).compile.last == Some(3))
  }
}

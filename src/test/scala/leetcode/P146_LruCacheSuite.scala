package leetcode

import leetcode.P146_LruCache.Cache._
import leetcode.P146_LruCache.DLList._
import leetcode.P146_LruCache._
import org.scalatest.funsuite.AnyFunSuite

class P146_LruCacheSuite extends AnyFunSuite {

  test("put 0") {
    val s0: State[Int, Int]       = State(Map.empty, None, None, 0)
    val s1                        = put(s0, 1, 100, 10)
    val expected: State[Int, Int] = State(Map(1 -> Node(None, 100, None)), Some(1), Some(1), 1)
    assert(s1 == expected)
  }

  test("put 1") {
    val s: State[Int, Int] =
      State(Map(1 -> Node(None, 100, None)), Some(1), Some(1), 1)

    val expected: State[Int, Int] =
      State(Map(2 -> Node(None, 200, Some(1)), 1 -> Node(Some(2), 100, None)), Some(2), Some(1), 2)

    assert(put(s, 2, 200, 10) == expected)
  }

  test("put 3") {
    val s =
      State(Map(2 -> Node(None, 200, Some(1)), 1 -> Node(Some(2), 100, None)), Some(2), Some(1), 2)

    val expected =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    assert(put(s, 3, 300, 10) == expected)
  }

  test("put 3 existing A") {
    val s =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    val expected =
      State(
        Map(
          2 -> Node(None, 2000, Some(3)),
          3 -> Node(Some(2), 300, Some(1)),
          1 -> Node(Some(3), 100, None)
        ),
        Some(2),
        Some(1),
        3
      )

    assert(put(s, 2, 2000, 10) == expected)
  }

  test("put 3 existing B") {
    val s =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    val expected =
      State(
        Map(
          3 -> Node(None, 3000, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    assert(put(s, 3, 3000, 10) == expected)
  }

  test("remove 3 A") {
    val s =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    val expected =
      State(
        Map(
          2 -> Node(None, 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(2),
        Some(1),
        2
      )

    assert(remove(s, 3) == expected)
  }

  test("remove 3 B") {
    val s =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    val expected =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, None)
        ),
        Some(3),
        Some(2),
        2
      )

    assert(remove(s, 1) == expected)
  }

  test("remove 3 C") {
    val s =
      State(
        Map(
          3 -> Node(None, 300, Some(2)),
          2 -> Node(Some(3), 200, Some(1)),
          1 -> Node(Some(2), 100, None)
        ),
        Some(3),
        Some(1),
        3
      )

    val expected =
      State(
        Map(
          3 -> Node(None, 300, Some(1)),
          1 -> Node(Some(3), 100, None)
        ),
        Some(3),
        Some(1),
        2
      )

    assert(remove(s, 2) == expected)
  }

  test("remove 3 D") {
    val s: State[Int, Int] =
      State(
        Map(1 -> Node(None, 100, None)),
        Some(1),
        Some(1),
        1
      )

    val expected: State[Int, Int] =
      State(
        Map.empty,
        None,
        None,
        0
      )

    assert(remove(s, 1) == expected)
  }

  test("put 0 eviction") {
    val s: State[Int, Int]        = State(Map.empty, None, None, 0)
    val expected: State[Int, Int] = State(Map.empty, None, None, 0)
    assert(put(s, 1, 100, 0) == expected)
  }

  test("put 1 eviction") {
    val s: State[Int, Int]        = State(Map(1 -> Node(None, 100, None)), Some(1), Some(1), 1)
    val expected: State[Int, Int] = State(Map(2 -> Node(None, 200, None)), Some(2), Some(2), 1)
    assert(put(s, 2, 200, 1) == expected)
  }

  test("put 2 eviction") {
    val s =
      State(Map(2 -> Node(None, 200, Some(1)), 1 -> Node(Some(2), 100, None)), Some(2), Some(1), 2)

    val expected =
      State(Map(3 -> Node(None, 300, Some(2)), 2 -> Node(Some(3), 200, None)), Some(3), Some(2), 2)
    assert(put(s, 3, 300, 2) == expected)
  }

  test("put 2 eviction existing") {
    val s =
      State(Map(2 -> Node(None, 200, Some(1)), 1 -> Node(Some(2), 100, None)), Some(2), Some(1), 2)

    val expected =
      State(Map(2 -> Node(None, 2000, Some(1)), 1 -> Node(Some(2), 100, None)), Some(2), Some(1), 2)
    assert(put(s, 2, 2000, 2) == expected)
  }

  test("get 0") {
    val s: State[Int, Int] = State(Map.empty, None, None, 0)
    assert(get(s, 1) == (s, None))
  }

  test("get 1") {
    val s: State[Int, Int] = State(Map(1 -> Node(None, 100, None)), Some(1), Some(1), 1)
    assert(get(s, 1) == (s, Some(100)))
  }

  test("get 2 existing") {
    val s =
      State(Map(2 -> Node(None, 200, Some(1)), 1 -> Node(Some(2), 100, None)), Some(2), Some(1), 2)

    val expected =
      State(Map(1 -> Node(None, 100, Some(2)), 2 -> Node(Some(1), 200, None)), Some(1), Some(2), 2)

    assert(get(s, 1) == (expected, Some(100)))
  }

}

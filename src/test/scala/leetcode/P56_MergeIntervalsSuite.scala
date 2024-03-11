package leetcode

import leetcode.P56_MergeIntervals.merge
import org.scalatest.funsuite.AnyFunSuite

class P56_MergeIntervalsSuite extends AnyFunSuite {
  test("merge") {
    val data1     = Array(Array(1, 3), Array(2, 6), Array(8, 10), Array(15, 18))
    val expected1 = Array(Array(1, 6), Array(8, 10), Array(15, 18))
    assert(merge(data1).flatten.toList == expected1.flatten.toList)

    val data2     = Array(Array(1, 4), Array(4, 5))
    val expected2 = Array(Array(1, 5))
    assert(merge(data2).flatten.toList == expected2.flatten.toList)

    val data3     = Array(Array(1, 4), Array(2, 3))
    val expected3 = Array(Array(1, 4))
    assert(merge(data3).flatten.toList == expected3.flatten.toList)

    val data4 = List((2, 3), (2, 2), (3, 3), (1, 3), (5, 7), (2, 2), (4, 6)).toArray
      .map(x => Array(x._1, x._2))
    val expected4 = Array(Array(1, 3), Array(4, 7))
    assert(merge(data4).flatten.toList == expected4.flatten.toList)
  }
}

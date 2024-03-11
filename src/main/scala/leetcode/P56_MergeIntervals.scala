package leetcode

object P56_MergeIntervals {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] =
    intervals
      .sorted(Ordering.by[Array[Int], (Int, Int)](xs => (xs(0), xs(1))))
      .foldLeft(Array.empty[Array[Int]]) { (acc, i1) =>
        acc.lastOption match {
          case None => Array(i1)
          case Some(i0) =>
            if (i0(1) >= i1(0)) acc.init :+ Array(i0(0), i1(1).max(i0(1)))
            else acc :+ i1
        }
      }

}

package leetcode

object P2428_MaximumSumHourglass {

  def maxSum(grid: Array[Array[Int]]): Int = {
    def hourglass(grid: Array[Array[Int]], i: Int, j: Int): Int =
      grid(i).slice(j, j + 3).sum +
        grid(i + 1)(j + 1) +
        grid(i + 2).slice(j, j + 3).sum

    def go(i: Int, j: Int, n: Int): Int = {
      if (i > grid.size - 3) n
      else if (j > grid(0).size - 3) go(i + 1, 0, n)
      else go(i, j + 1, hourglass(grid, i, j).max(n))
    }
    go(0, 0, 0)
  }

}

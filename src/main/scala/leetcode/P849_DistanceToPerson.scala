package leetcode

object P849_DistanceToPerson {

  def maxDistToClosest(seats: Array[Int]): Int = {
    def go(i: Int, l: Int, n: Int, mx: Int): Int =
      if (i >= seats.size) List(l, (mx + 1) / 2, n).max
      else if (seats(i) == 0) go(i + 1, l, n + 1, (n + 1).max(mx))
      else if (l == -1) go(i + 1, n, 0, mx)
      else go(i + 1, l, 0, mx)

    go(0, -1, 0, 0)
  }

}

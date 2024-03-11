package leetcode

/** Given an array of integers nums and an integer target, return indices of the two numbers such
  * that they add up to target.
  *
  * You may assume that each input would have exactly one solution, and you may not use the same
  * element twice.
  *
  * You can return the answer in any order.
  */
object P1_TwoSum {

  def twoSum(xs: Vector[Int], target: Int): (Int, Int) = {
    def go(xs: Vector[(Int, Int)]): (Int, Int) =
      xs.tail.collectFirst { case (b, i) if xs.head._1 + b == target => i } match {
        case Some(j) => (xs.head._2, j)
        case None    => go(xs.tail)
      }

    go(xs.zipWithIndex)
  }

  def twoSumStream(xs: Vector[Int], target: Int): (Int, Int) = {

    def tuple[A](xs: LazyList[A]): (A, A) = {
      val ys = xs.toVector
      (ys(0), ys(1))
    }

    LazyList
      .from(xs.zipWithIndex)
      .combinations(2)
      .map { ys =>
        val (a, b) = tuple(ys)

        if (a._1 + b._1 == target) Some((a._2, b._2))
        else None
      }
      .collectFirst { case Some(v) => v }
      .getOrElse((0, 0))

  }

  def twoSumImperative(xs: Vector[Int], target: Int): (Int, Int) = {
    var done = false
    var i    = 0
    var j    = 1
    var r    = (0, 0)
    while (!done && i < xs.size - 1) {
      val a = xs(i)
      while (!done && j < xs.size) {
        val b = xs(j)

        if (a + b == target) {
          r = (i, j)
          done = true
        } else ()

        j = j + 1
      }
      i = i + 1
      j = i + 1
    }

    r
  }

  def twoSumLinear(xs: Vector[Int], target: Int): (Int, Int) = {
    def go(i: Int, m: Map[Int, Int]): (Int, Int) =
      m.get(target - xs(i)) match {
        case Some(i0) => (i0, i)
        case None     => go(i + 1, m.updated(xs(i), i))
      }

    go(0, Map.empty)
  }

}

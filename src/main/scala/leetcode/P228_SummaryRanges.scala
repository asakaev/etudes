package leetcode

object P228_SummaryRanges {

  def summaryRanges(nums: Array[Int]): List[String] =
    nums
      .foldLeft(List.empty[(Int, Int)]) { (acc, x) =>
        acc match {
          case Nil => (x, x) :: Nil
          case (l, r) :: tl =>
            if ((r - x).abs > 1) (x, x) :: (l, r) :: tl
            else (l, x) :: tl
        }
      }
      .reverse
      .map { case (l, r) => if (l == r) s"$l" else s"$l->$r" }

}

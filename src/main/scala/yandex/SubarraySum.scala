package yandex

object SubarraySum {

  def subarraySum(xs: List[Int], target: Int): (Int, Int) = {
    def go(ys: List[Int], i: Int, s: Int, m: Map[Int, Int]): (Int, Int) =
      ys match {
        case Nil => (-1, -1)
        case h :: tl =>
          val s1 = s + h
          m.get(s1 - target) match {
            case Some(i1) => (i1 + 1, i + 1)
            case None     => go(tl, i + 1, s1, m.updated(s1, i))
          }
      }

    go(xs, 0, 0, Map.empty)
  }

}

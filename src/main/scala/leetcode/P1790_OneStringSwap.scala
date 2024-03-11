package leetcode

object P1790_OneStringSwap {

  def areAlmostEqual(s1: String, s2: String): Boolean = {
    def go(i: Int, s: List[Int]): Boolean =
      if (s.size > 2) false
      else if (i >= s1.size) s match {
        case Nil           => true
        case r :: l :: Nil => s1(l) == s2(r) && s1(r) == s2(l)
        case _             => false
      }
      else if (s1(i) != s2(i)) go(i + 1, i :: s)
      else go(i + 1, s)

    go(0, Nil)
  }

}

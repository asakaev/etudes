package leetcode

object P567_PermutationString {

  def checkInclusion(s1: String, s2: String): Boolean = {
    def occurrences(s: String): Map[Char, Int] =
      s.groupMapReduce(identity)(_ => 1)(_ + _)

    val m1: Map[Char, Int] = occurrences(s1)

    def go(m: Map[Char, Int], i: Int): Boolean =
      if (i >= s2.size - s1.size) m1 == m
      else if (m1 == m) true
      else {
        val m2: Map[Char, Int] =
          m
            .updatedWith(s2(i)) {
              case None    => None
              case Some(n) => Option.when(n - 1 > 0)(n - 1)
            }
            .updatedWith(s2(i + s1.size)) {
              case None    => Some(1)
              case Some(n) => Some(n + 1)
            }

        go(m2, i + 1)
      }

    go(occurrences(s2.take(s1.size)), 0)
  }

}

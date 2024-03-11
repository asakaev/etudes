package leetcode

object P2423_EqualFrequency {

  def equalFrequency(word: String): Boolean = {
    val m = word.foldLeft(Map.empty[Char, Int]) { (m, c) =>
      m.updatedWith(c) {
        case None    => Some(1)
        case Some(n) => Some(n + 1)
      }
    }

    m.keys.exists { c =>
      val m0 = m.updatedWith(c) {
        case None              => None
        case Some(n) if n == 1 => None
        case Some(n)           => Some(n - 1)
      }
      m0.values.toSet.size == 1
    }
  }

}

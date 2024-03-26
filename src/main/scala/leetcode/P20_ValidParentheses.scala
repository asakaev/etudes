package leetcode

object P20_ValidParentheses {

  def isValid(s: String): Boolean = {
    val m = Map('(' -> ')', '{' -> '}', '[' -> ']')

    def go(i: Int, xs: List[Char]): Boolean =
      if (i >= s.size) xs.isEmpty
      else if (m.contains(s(i))) go(i + 1, s(i) :: xs)
      else
        xs match {
          case Nil => false
          case h :: tl =>
            if (s(i) != m(h)) false
            else go(i + 1, tl)
        }

    go(0, Nil)
  }

}

package leetcode

object P125_ValidPalindrome {

  def isPalindrome(s: String): Boolean = {
    val s1 = s.toLowerCase.filter(_.isLetterOrDigit)
    s1 == s1.reverse
  }

  def isPalindrome2(s: String): Boolean = {
    def go(l: Int, r: Int): Boolean =
      if (l >= r) true
      else if (!s(l).isLetterOrDigit) go(l + 1, r)
      else if (!s(r).isLetterOrDigit) go(l, r - 1)
      else if (s(l).toLower == s(r).toLower) go(l + 1, r - 1)
      else false

    go(0, s.size - 1)
  }

}

package leetcode

object P443_StringCompression {

  def compress(chars: Array[Char]): Int = {
    val s  = rle(chars.mkString)
    val sz = s.size
    val xs = rle(chars.mkString).toCharArray
    val _  = Array.copy(xs, 0, chars, 0, sz)
    sz
  }

  def rle(s: String): String = {
    def encode(s: String, ch: Char, n: Int): String =
      if (ch == ' ') s
      else if (n < 2) s"$s$ch"
      else s"$s$ch$n"

    def go(in: String, ch: Char, n: Int, out: String): String =
      if (in.isEmpty) encode(out, ch, n)
      else {
        val h  = in.head
        val tl = in.tail

        if (h == ch) go(tl, ch, n + 1, out)
        else go(tl, h, 1, encode(out, ch, n))
      }

    go(s, ' ', 0, "")
  }

}

package sequence

object InsertSpaces {

  def insertSpaces(dict: Set[String], text: String): List[String] = {
    def go(s: String, words: List[String], seen: Set[String]): Stream[List[String]] =
      if (s.isEmpty) Stream(words.reverse)
      else
        chunks(s).find { case (w, _) => dict.contains(w) && !seen.contains(w) } match {
          case None           => Stream.empty
          case Some((w, rem)) => go(rem, w :: words, Set.empty) ++ go(w + rem, words, seen + w)
        }

    go(text, Nil, Set.empty).map(_.mkString(" ")).toList
  }

  /**
    * Scan string
    * Example: abcd => [("a", "bcd"), ("ab", "cd"), ("abc", "d"), ("abcd", "")]
    */
  def chunks(s: String): Stream[(String, String)] = {
    def go(l: String, r: String): Stream[(String, String)] =
      if (r.isEmpty) Stream.empty
      else Stream((l + r.head, r.tail)) ++ go(l + r.head, r.tail)

    go("", s)
  }

}

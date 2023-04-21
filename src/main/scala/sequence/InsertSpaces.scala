package sequence

import scala.annotation.tailrec

object InsertSpaces {

  def insertSpaces(dict: Set[String], text: String): List[String] = {
    def go(s: String, words: List[String], seen: Set[String]): List[List[String]] = {
      if (s.isEmpty) List(words.reverse)
      else {
        val found: Option[(String, String)] =
          chunks(s).find { case (w, _) => dict.contains(w) && !seen.contains(w) }

        found match {
          case None => Nil
          case Some((word, rem)) =>
            go(rem, word :: words, Set.empty) ++
              go(word + rem, words, seen + word)
        }
      }
    }

    go(text, Nil, Set.empty).map(_.mkString(" "))
  }

  /**
    * Scan string
    * Example: abcd => [("a", "bcd"), ("ab", "cd"), ("abc", "d"), ("abcd", "")]
    */
  def chunks(s: String): List[(String, String)] = {
    @tailrec def go(xs: List[(String, String)], s: String): List[(String, String)] =
      if (s.isEmpty) xs
      else
        xs match {
          case Nil          => go(List(s.head.toString -> s.tail), s.tail)
          case (l, r) :: tl => go((l + s.head, r.tail) :: (l, r) :: tl, s.tail)
        }

    go(Nil, s).reverse
  }

}

package sequence

import scala.annotation.tailrec

object InsertSpaces {

  final case class State(text: String, words: List[String], seen: Set[String])

  def insertSpaces(dict: Set[String], text: String): List[String] = {
    def go(s: State): List[List[String]] = {
      if (s.text.isEmpty) List(s.words.reverse)
      else {
        val found: Option[(String, String)] =
          chunks(s.text).find { case (w, _) => dict.contains(w) && !s.seen.contains(w) }

        found match {
          case None => Nil
          case Some((word, rem)) =>
            go(State(rem, word :: s.words, Set.empty)) ++
              go(State(word + rem, s.words, s.seen + word))
        }
      }
    }

    go(State(text, Nil, Set.empty)).map(_.mkString(" "))
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

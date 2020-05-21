package impure

object Iterators {

  def flatten(i: Iterator[Any]): Iterator[String] =
    i.flatMap {
      case s: String       => Iterator(s)
      case it: Iterator[_] => flatten(it)
      case _               => Iterator.empty
    }

}

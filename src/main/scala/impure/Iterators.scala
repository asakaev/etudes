package impure

object Iterators {

  def flatten(i: Iterator[Any]): Iterator[String] =
    i.flatMap {
      case s: String       => Iterator.single(s)
      case it: Iterator[_] => Iterator.empty ++ flatten(it)
      case _               => Iterator.empty
    }

  def roundRobin[A](iterators: Iterator[A]*): Iterator[A] = {
    def go(s: (List[Iterator[A]], List[Iterator[A]])): Iterator[A] = s match {
      case (Nil, Nil)                 => Iterator.empty
      case (Nil, ys)                  => go(ys.reverse -> Nil)
      case (x :: xs, ys) if x.hasNext => Iterator.single(x.next()) ++ go(xs -> (x :: ys))
      case (_ :: xs, ys)              => go(xs -> ys)
    }
    go(iterators.toList -> Nil)
  }

}

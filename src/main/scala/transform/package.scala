package object transform {

  def fallback[A, B](a: Option[A], b: Option[B]): Option[Either[A, B]] =
    a.map(Left(_)).orElse(b.map(Right(_)))

}

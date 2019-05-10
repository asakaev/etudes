package wonderland

final case class Kleisli[F[_]: Monad, A, B](run: A => F[B]) {
  def compose[Z](k: Kleisli[F, Z, A]): Kleisli[F, Z, B] =
    Kleisli[F, Z, B](z => Monad[F].flatMap(k.run(z))(run))

  def andThen[C](k: Kleisli[F, B, C]): Kleisli[F, A, C] =
    Kleisli[F, A, C](a => Monad[F].flatMap(run(a))(k.run(_)))
}

package streams

import fs2.{Pull, Pure, Stream}

object Streams {

  def fold[A, B](s: Stream[Pure, A])(z: B)(f: (B, A) => B): B = {
    def go(acc: B, s: Stream[Pure, A]): Pull[Pure, B, Unit] =
      s.pull.uncons1.flatMap {
        case None          => Pull.output1(acc)
        case Some((h, tl)) => go(f(acc, h), tl)
      }
    go(z, s).stream.compile.last.getOrElse(z)
  }

}

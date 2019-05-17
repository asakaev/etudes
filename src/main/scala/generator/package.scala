import fs2._

import scala.annotation.tailrec

package object generator {

  def fibonacci(n: Int): Int = {
    @tailrec def loop(n: Int, a: Int, b: Int): Int = n match {
      case 1 => a
      case 2 => b
      case _ => loop(n - 1, b, a + b)
    }
    loop(n, 0, 1)
  }

  val fibonacci: Stream[Pure, Int] =
    Stream(0) ++ fibonacci.scan(1)(_ + _)

}

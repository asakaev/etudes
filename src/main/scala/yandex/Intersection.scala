package yandex

/** Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
  *
  * Надо вернуть [1, 2, 2, 3] (порядок неважен)
  */
object Intersection {

  def intersectionHash(xs: Vector[Int], ys: Vector[Int]): Vector[Int] = {
    val m = ys.foldLeft(Map.empty[Int, Int]) { (m, x) =>
      m.updatedWith(x) {
        case None    => Some(1)
        case Some(n) => Some(n + 1)
      }

    }

    xs.foldLeft((m, Vector.empty[Int])) { case ((m, acc), x) =>
      m.get(x) match {
        case None => (m, acc)
        case Some(n0) =>
          val n = n0 - 1

          if (n > 0) (m.updated(x, n), acc :+ x)
          else (m.removed(x), acc :+ x)
      }
    }._2
  }

}

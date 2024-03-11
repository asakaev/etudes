package leetcode

object P356_LineReflection {

  def reflected(xs: List[(Int, Int)]): Boolean = {
    val (s, mn, mx) = xs.foldLeft((Set.empty[(Int, Int)], Int.MaxValue, Int.MinValue)) {
      case ((s, mn, mx), (x, y)) => (s + ((x, y)), mn.min(x), mx.max(x))
    }

    xs.forall { case (x, y) => s((mn + mx - x, y)) }
  }

  def reflected2(xs: List[(Int, Int)]): Boolean = {
    val (mn, mx) = xs.foldLeft((Int.MaxValue, Int.MinValue)) { case ((mn, mx), (x, _)) =>
      (mn.min(x), mx.max(x))
    }

    val m = xs.foldLeft(Map.empty[(Int, Int), Int]) { case (m, (x, y)) =>
      val p0 = (x, y)
      val p  = (mn + mx - x, y)

      if (m.isDefinedAt(p))
        m.updatedWith(p) {
          case None              => None
          case Some(n) if n == 1 => None
          case Some(n)           => Some(n - 1)
        }
      else
        m.updatedWith(p0) {
          case None    => Some(1)
          case Some(n) => Some(n + 1)
        }
    }

    m.isEmpty
  }

}

package codebattle

object Codebattle {

  def boxesVolume(boxes: List[List[Int]]): Int =
    boxes.foldLeft(0) { (acc, box) =>
      acc + box.product
    }

  def positiveDominant(xs: List[Int]): Boolean = {
    val (pos, neg) = xs.distinct.foldLeft((0, 0)) {
      case ((pos, neg), x) => if (x >= 0) (pos + 1, neg) else (pos, neg + 1)
    }

    pos > neg
  }

}

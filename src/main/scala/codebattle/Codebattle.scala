package codebattle

object Codebattle {

  /**
    * Given an array of boxes, create a function that returns the total volume of all those boxes
    * combined together. A box is represented by an array with three elements: length, width and
    * height. Each box will always have three dimensions.
    */
  def boxesVolume(boxes: List[List[Int]]): Int =
    boxes.foldLeft(0) { (acc, box) =>
      acc + box.product
    }

  /**
    * Create a function, thats check if positive numbers are greater than negative ones in
    * `numbers` array after removing duplicates (array may contains zeros).
    */
  def positiveDominant(xs: List[Int]): Boolean = {
    val (pos, neg) = xs.distinct.foldLeft((0, 0)) {
      case ((pos, neg), x) => if (x >= 0) (pos + 1, neg) else (pos, neg + 1)
    }

    pos > neg
  }

  /**
    * Given a number as input, return a string with that number formatted with commas to separate
    * each three digits from the right to make it look like a standard North American number.
    */
  def separateWithComma(n: Int): String =
    n.toString.reverse.grouped(3).mkString(",").reverse

  /**
    * Given a hash map, return the keys of the elements with the smallest value.
    * The result should be sorted alphabetically.
    */
  def keyForMinValue(m: Map[String, Int]): List[String] = {
    val (_, min) = m.minBy(_._2)

    m.foldLeft(List.empty[String]) {
        case (xs, (k, v)) => if (v == min) k :: xs else xs
      }
      .sorted
  }

}

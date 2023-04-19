package codebattle

object Codebattle {

  def boxesVolume(boxes: List[List[Int]]): Int =
    boxes.foldLeft(0) { (acc, box) =>
      acc + box.product
    }

}

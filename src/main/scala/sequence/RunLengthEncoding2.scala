package sequence

object RunLengthEncoding2 {

  /**
    * Сжать последовательность интов
    * Seq(1, 2, 2, 3, 4, 3, 3, 3) => Seq((1, 1), (2, 2), (3, 1), (4, 1), (3, 3))
    * Ответ выдать в виде Seq[(Int, Int)]
    * (число из последовательности и число последовательных повторений)
    */
  def rle[A](xs: List[A]): List[(A, Int)] =
    xs.foldLeft(List.empty[(A, Int)]) {
        case (ys, a) =>
          ys match {
            case (b, n) :: tl if a == b => (a, n + 1) :: tl
            case ys                     => (a, 1) :: ys
          }
      }
      .reverse

}

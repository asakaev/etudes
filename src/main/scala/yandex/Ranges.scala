package yandex

/** Дан список интов, повторяющихся элементов в списке нет. Нужно преобразовать это множество в
  * строку, сворачивая соседние по числовому ряду числа в диапазоны.
  *
  * Примеры: [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11", [1,4,3,2] => "1-4", [1,4] => "1,4"
  */
object Ranges {

  sealed trait Range extends Product with Serializable
  object Range {
    case class One(v: Int)          extends Range
    case class Both(l: Int, r: Int) extends Range
  }

  def ranges(xs: List[Int]): List[Range] = {
    def range(l: Option[Int], r: Option[Int]): Option[Range] =
      (l, r) match {
        case (Some(l), Some(r)) => Some(Range.Both(l, r))
        case (Some(l), _)       => Some(Range.One(l))
        case _                  => None
      }

    def go(
        xs: List[Int],
        l: Option[Int],
        r: Option[Int],
        ys: List[Range]
    ): List[Range] = xs match {
      case Nil => range(l, r).toList ++ ys
      case h :: tl =>
        (l, r) match {
          case (Some(_), Some(rv)) if h - rv <= 1 => go(tl, l, Some(h), ys)
          case (Some(_), Some(_))                 => go(tl, Some(h), None, range(l, r).toList ++ ys)
          case (Some(lv), None) if h - lv <= 1    => go(tl, l, Some(h), ys)
          case (Some(_), None)                    => go(tl, Some(h), None, range(l, r).toList ++ ys)
          case _                                  => go(tl, Some(h), None, ys)

        }
    }

    go(xs.sorted, None, None, Nil)
  }

}

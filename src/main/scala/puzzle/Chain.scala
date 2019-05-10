package puzzle

/**
 * Transformation Chain
 *
 * Дан набор возможных трансформаций: type Transformation[T] = T => Option[T]
 * Написать функцию преобразования последовательности трансформаций в возможную трансформацию.
 * Новая трансформация это результат работы всей цепочки трансформаций, которые не вернули None.
 * Если все вернули None, то общий результат None.
 */
object Chain {

  type Transformation[T] = T => Option[T]

  def transformationChain[T](chain: Seq[Transformation[T]]): Transformation[T] =
    x =>
      chain.foldLeft(Option.empty[T]) { (o, f) =>
        o.fold(f(x))(f(_).orElse(o))
    }

}

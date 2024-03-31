package codec

object JsonCodec {

  /** Исходные данные: Упрощенная модель для представления JSON объекта.
    */

  sealed trait JVal
  case class JStr(str: String)    extends JVal
  case class JBool(bool: Boolean) extends JVal
  case class JNum(long: Long)     extends JVal

  sealed trait JType
  object JStr  extends JType
  object JBool extends JType
  object JNum  extends JType

  type JsonObj = Map[String, JVal]

  /** Необходимо написать функцию генерации JSON декодера, принимающую на вход описание в формате:
    * ("name" -> JStr) :: ("active" -> JBool) :: ("age" -> JNum) :: Nil : List[(String, JType)] и
    * возвращающую декодер типа Decoder.
    */
  case class Error(cause: String)

  type DecoderResult = Either[Error, Map[String, JVal]]

  type Decoder = Map[String, String] => DecoderResult

  // implementation

  def jVal(t: JType, s: String): Either[Error, JVal] = t match {
    case JBool => s.toBooleanOption.map(JBool.apply).toRight(Error("JBool"))
    case JNum  => s.toLongOption.map(JNum.apply).toRight(Error("JNum"))
    case JStr  => Right(JStr(s))
  }

  def traverse[K, V, K1, V1, E](
      m: Map[K, V]
  )(f: (K, V) => Either[E, (K1, V1)]): Either[E, Map[K1, V1]] = {
    def go(m: Map[K, V], acc: Either[E, Map[K1, V1]]): Either[E, Map[K1, V1]] =
      m.headOption match {
        case None => acc
        case Some((k, v)) =>
          f(k, v) match {
            case Left(e)         => Left(e)
            case Right((k1, v1)) => go(m.tail, acc.map(_.updated(k1, v1)))
          }
      }
    go(m, Right(Map.empty))
  }

  def decoder(schema: List[(String, JType)]): Decoder = {
    val m: Map[String, JType] = schema.toMap
    data =>
      traverse(data) { (k, v) =>
        m.get(k) match {
          case None    => Left(Error("JType"))
          case Some(t) => jVal(t, v).map((k, _))
        }
      }
  }

}

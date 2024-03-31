package codec

import codec.JsonCodec._
import org.scalatest.funsuite.AnyFunSuite

class JsonCodecSuite extends AnyFunSuite {

  test("decoder1") {
    val schema: Map[String, JType] = Map("age" -> JNum, "name" -> JStr, "active" -> JBool)
    val data: Map[String, String]  = Map("age" -> "20", "name" -> "Alice", "active" -> "true")

    val dec: Decoder = decoder(schema.toList)
    val expected = Map("age" -> JNum(20L), "name" -> JStr("Alice"), "active" -> JBool(bool = true))
    assert(dec(data) == Right(expected))
  }

  test("decoder2") {
    val data: Map[String, String] = Map("age" -> "20", "name" -> "Alice", "active" -> "true")

    val dec: Decoder = decoder(Nil)
    assert(dec(data) == Left(Error("JType")))
  }

  test("decoder3") {
    val schema: Map[String, JType] = Map("age" -> JNum, "name" -> JStr, "active" -> JBool)
    val data: Map[String, String]  = Map("age" -> "Yolo", "name" -> "Alice")

    val dec: Decoder = decoder(schema.toList)
    assert(dec(data) == Left(Error("JNum")))
  }

  test("decoder4") {
    val schema: Map[String, JType] = Map("age" -> JNum, "name" -> JStr, "active" -> JBool)
    val data: Map[String, String]  = Map("age" -> "20", "name" -> "Alice")

    val dec: Decoder = decoder(schema.toList)
    val expected     = Map("age" -> JNum(20L), "name" -> JStr("Alice"))
    assert(dec(data) == Right(expected))
  }

}

package future

import future.Traverse._
import org.scalatest.funsuite.AsyncFunSuite

import scala.concurrent.{ExecutionContext, Future}

class TraverseSpec extends AsyncFunSuite {
  import TraverseSpec._

  test("foldUnzip") {
    val expected = List("я", "немного", "заикаюсь") -> List(".", "..", "...")
    foldUnzip(talk).map {
      case (ss, es) => assert(ss -> es.map(_.getMessage) == expected)
    }
  }

  test("foldUnzipPar") {
    val expected = List("я", "немного", "заикаюсь") -> List(".", "..", "...")
    foldUnzipPar(talk).map {
      case (ss, es) => assert(ss -> es.map(_.getMessage) == expected)
    }
  }

}

object TraverseSpec {
  def talk(implicit ec: ExecutionContext): Seq[Future[String]] =
    Seq(
      Future {
        Thread.sleep(1000)
        "я"
      },
      Future.failed(new RuntimeException(".")),
      Future.successful("немного"),
      Future.failed(new RuntimeException("..")),
      Future.successful("заикаюсь"),
      Future.failed(new RuntimeException("..."))
    )
}

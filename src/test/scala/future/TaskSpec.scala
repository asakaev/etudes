package future

import org.scalatest.funsuite.AsyncFunSuite

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.{DurationInt, FiniteDuration}

class TaskSpec extends AsyncFunSuite {
  import Task._

  implicit override def executionContext: ExecutionContext =
    scala.concurrent.ExecutionContext.Implicits.global

  test("traverse") {
    val xs: List[Task[Int]] = List(1, 2, 3).map(Task.unit)
    Task
      .traverse(xs)(i => Task.unit(i.toString))
      .map(xs => assert(xs == List("1", "2", "3")))
      .future
  }

  test("parTraverse") {
    val delay = 1.second

    val task: Task[FiniteDuration] =
      for {
        t <- Task.now
        _ <- Task.sleep(delay)
      } yield t

    val tasks4: List[Task[FiniteDuration]] =
      Range.inclusive(1, 4).map(_ => task).toList

    Task
      .parTraverse(2)(tasks4)(Task.unit)
      .map { xs =>
        val betweenGroups = xs.grouped(2).map(_.head).reduce((a, b) => b - a).toSeconds
        val insideGroup   = xs.grouped(2).map(_.reduce((a, b) => b - a).toSeconds).toList
        betweenGroups == delay.toSeconds && insideGroup.forall(_ == 0)
      }
      .map(assert(_))
      .future
  }

}

package future

import org.scalatest.funsuite.AsyncFunSuite

class TaskSpec extends AsyncFunSuite {
  import Task._

  test("traverse") {
    val xs: List[Task[Int]] = List(1, 2, 3).map(Task.unit)
    Task
      .traverse(xs)(i => Task.unit(i.toString))
      .map(xs => assert(xs == List("1", "2", "3")))
      .future
  }

}

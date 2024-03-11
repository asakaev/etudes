package leetcode

import leetcode.P206_ReverseList.{ListNode, reverseList}
import org.scalatest.funsuite.AnyFunSuite

class P206_ReverseListSuite extends AnyFunSuite {
  import P206_ReverseListSuite._

  test("reverseList") {
    val xs1 = List(1, 2, 3, 4, 5)
    assert(list(reverseList(listNode(xs1))) == xs1.reverse)

    val xs2 = Nil
    assert(list(reverseList(listNode(xs2))) == xs2.reverse)
  }

}

object P206_ReverseListSuite {

  def list(xs: ListNode): List[Int] = {
    def go(xs: ListNode, acc: List[Int]): List[Int] =
      if (xs.next == null) xs.x :: acc
      else go(xs.next, xs.x :: acc)

    if (xs == null) Nil
    else go(xs, Nil).reverse
  }

  def listNode(xs: List[Int]): ListNode =
    xs.reverse.foldLeft(null: ListNode) { (acc, x) =>
      new ListNode(x, acc)
    }

}

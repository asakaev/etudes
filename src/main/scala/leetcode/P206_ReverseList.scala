package leetcode

object P206_ReverseList {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int         = _x
  }

  def reverseList(head: ListNode): ListNode = {
    def go(xs: ListNode, acc: ListNode): ListNode =
      if (xs == null) acc
      else go(xs.next, new ListNode(xs.x, acc))

    go(head, null)
  }

}

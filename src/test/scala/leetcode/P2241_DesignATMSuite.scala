package leetcode

import leetcode.P2241_DesignATM.ATM
import leetcode.P2241_DesignATM.Ops.{deposit, withdraw}
import leetcode.P2241_DesignATMSuite.list
import org.scalatest.funsuite.AnyFunSuite

class P2241_DesignATMSuite extends AnyFunSuite {

  test("withdraw1") {
    val state    = Array(0, 2, 1, 1, 0)
    val res      = withdraw(state, 300)
    val expected = Array(0, 2, 0, 0, 0) -> Array(0, 0, 1, 1, 0)
    assert(list(res) == list(Some(expected)))
  }

  test("withdraw2") {
    val state    = Array(0, 10, 0, 3, 0)
    val res      = withdraw(state, 500)
    val expected = Array(0, 8, 0, 1, 0) -> Array(0, 2, 0, 2, 0)
    assert(list(res) == list(Some(expected)))
  }

  test("withdraw3") {
    val state    = Array(0, 0, 1, 2, 1)
    val res      = withdraw(state, 600)
    val expected = Array(0, 0, 0, 2, 0) -> Array(0, 0, 1, 0, 1)
    assert(list(res) == list(Some(expected)))
  }

  test("withdraw4") {
    val state    = Array(0, 1, 0, 3, 1)
    val expected = None
    assert(withdraw(state, 600) == expected)
  }

  test("withdraw5") {
    val state    = Array(0, 0, 1, 2, 1)
    val res      = withdraw(state, 600)
    val expected = Array(0, 0, 0, 2, 0) -> Array(0, 0, 1, 0, 1)
    assert(list(res) == list(Some(expected)))
  }

  test("withdraw6") {
    val state = Array(0, 1, 0, 3, 1)
    val res   = withdraw(state, 600)
    assert(res == None)
  }

  test("withdraw7") {
    val state    = Array(0, 1, 0, 3, 1)
    val res      = withdraw(state, 550)
    val expected = Array(0, 0, 0, 3, 0) -> Array(0, 1, 0, 0, 1)
    assert(list(res) == list(Some(expected)))
  }

  test("seq1") {
    val atm = new ATM()
    atm.deposit(Array(0, 0, 1, 2, 1))
    atm.withdraw(600)
    atm.deposit(Array(0, 1, 0, 1, 1))
    atm.withdraw(600)
    val res = atm.withdraw(550)
    assert(res.toList == Array(0, 1, 0, 0, 1).toList)
  }

  test("deposit") {
    val l        = Array(0, 0, 0, 2, 0)
    val r        = Array(0, 1, 0, 1, 1)
    val res      = deposit(l, r)
    val expected = Array(0, 1, 0, 3, 1)
    assert(res.toList == expected.toList)
  }

}

object P2241_DesignATMSuite {
  def list(
      v: Option[(Array[Int], Array[Int])]
  ): Option[(List[Int], List[Int])] =
    v.map { case (xs, ys) => xs.toList -> ys.toList }
}

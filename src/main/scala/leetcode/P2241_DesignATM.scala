package leetcode

object P2241_DesignATM {

  class ATM() {
    var ref: Array[Int] = Array(0, 0, 0, 0, 0)

    def deposit(banknotesCount: Array[Int]): Unit =
      ref = ATM.deposit(ref, banknotesCount)

    def withdraw(amount: Int): Array[Int] = {
      val r = ATM.withdraw(ref, amount)
      ref = r.fold(ref)(_._1)
      r.fold(Array(-1))(_._2)
    }
  }

  object ATM {
    def withdraw(xs: Array[Int], n: Int): Option[(Array[Int], Array[Int])] = {
      def go(
          xs: List[(Int, Int)],
          v: Int,
          a: Array[Int],
          b: Array[Int]
      ): Option[(Array[Int], Array[Int])] =
        if (v == 0) Some(a -> b)
        else
          xs match {
            case Nil => None
            case (x, i) :: tl =>
              val n = (v / x).min(a(i))
              go(tl, v - x * n, a.updated(i, a(i) - n), b.updated(i, b(i) + n))
          }

      val data = List(500 -> 4, 200 -> 3, 100 -> 2, 50 -> 1, 20 -> 0)
      go(data, n, xs, Array(0, 0, 0, 0, 0))
    }

    def deposit(xs: Array[Int], ys: Array[Int]): Array[Int] =
      xs.zip(ys).map { case (a, b) => a + b }
  }

}

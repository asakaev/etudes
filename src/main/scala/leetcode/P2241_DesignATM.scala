package leetcode

object P2241_DesignATM {

  object Ops {
    def withdraw(
        xs: Array[Int],
        amount: Int
    ): Option[(Array[Int], Array[Int])] = {
      def go(
          data: List[(Int, Int)],
          amount: Int,
          xs: Array[Int],
          ys: Array[Int]
      ): Option[(Array[Int], Array[Int])] =
        if (amount == 0) Some(xs -> ys)
        else
          data match {
            case Nil => None
            case (x, i) :: tl =>
              val n = (amount / x).min(xs(i))
              if (n == 0) go(tl, amount, xs, ys)
              else
                go(
                  data,
                  amount - x * n,
                  xs.updated(i, xs(i) - n),
                  ys.updated(i, ys(i) + n)
                )
          }

      go(
        List(500 -> 4, 200 -> 3, 100 -> 2, 50 -> 1, 20 -> 0),
        amount,
        xs,
        Array(0, 0, 0, 0, 0)
      )
    }

    def deposit(xs: Array[Int], ys: Array[Int]): Array[Int] =
      xs.zip(ys).map { case (a, b) => a + b }
  }

  class ATM() {
    var ref: Array[Int] = Array(0, 0, 0, 0, 0)

    def deposit(banknotesCount: Array[Int]): Unit = {
      ref = Ops.deposit(ref, banknotesCount)
    }

    def withdraw(amount: Int): Array[Int] = {
      val r = Ops.withdraw(ref, amount)
      ref = r.fold(ref)(_._1)
      r.fold(Array(-1))(_._2)
    }
  }

}

package math

import java.lang.Math.{ pow, sqrt }

import scala.annotation.tailrec

object Mathematics {

  /**
   * Write a function that, given an integer N, returns the smallest number with the same number of digits.
   * You can assume N is between 1 and pow(10, 9) (a billion).
   *
   * For example, given N = 125, the function should return 100.
   * Given N = 10, the function should return 10.
   * Given N = 1, the function should return 0.
   */
  def smallest(n: Int): Int =
    n.toString.length match {
      case 1 => 0
      case d => pow(10, d - 1).toInt
    }

  /**
   * Write a function that, given two integers A and B, returns the maximum number of repeated square root operations
   * that can be performed using the numbers from interval [A..B] (both ends included) as starting points.
   * Square root operations can be performed as long as the result still an integer.
   *
   * For example, given A = 10, B = 20, the function should return 2. Starting with the integer 16, two square root
   * operations can be performed: sqrt(16) = 4 and then sqrt(4) = 2.
   *
   * Given A = 6000 and B = 7000, the function should return 3. Starting with integer 6561, three square root
   * operations can be performed: sqrt(6561) = 81, sqrt(81) = 9 and sqrt(9) = 3.
   *
   * Write an efficient algorithm for the following assumptions:
   * - A and B are integers within the range [2..1000000000]
   * - A <= B
   */
  // TODO: wrong implementation
  def roots(a: Int, b: Int): Int = {
    @tailrec def go(n: Int, x: Int): Int =
      sqrt(x).toInt match {
        case 1  => n
        case sq => go(n + 1, sq)
      }
    go(1, sqrt(b).toInt)
  }

  /**
   * Determines an even or odd number
   */
  @tailrec def even(n: Int): Boolean = n match {
    case x if x == 0 => true
    case x if x == 1 => false
    case x           => even(x - 2)
  }

}

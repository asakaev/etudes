package leetcode

object P136_SingleNumber {

  def singleNumber(nums: Array[Int]): Int = {
    nums.foldLeft(0)(_ ^ _)
  }

}

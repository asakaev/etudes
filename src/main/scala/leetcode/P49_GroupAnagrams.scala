package leetcode

object P49_GroupAnagrams {

  def groupAnagrams(strs: Array[String]): List[List[String]] =
    strs.toList.groupBy(_.sorted).values.toList

}

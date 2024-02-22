package cracking

import scala.annotation.tailrec

object ArraysStrings {

  // 1.1
  def allUnique1(s: String): Boolean =
    s.size == s.toSet.size

  // 1.1
  def allUnique2(s: String): Boolean = {
    @tailrec def headUnique(s: String, isUnique: Boolean): Boolean =
      if (!isUnique || s.size < 2) isUnique
      else if (s(0) == s(1)) false
      else headUnique(s(0).toString + s.drop(2), isUnique = true)

    @tailrec def loop(s: String, isUnique: Boolean): Boolean =
      if (!isUnique || s.isEmpty) isUnique
      else if (!headUnique(s, isUnique = true)) false
      else loop(s.tail, isUnique = true)

    loop(s, isUnique = true)
  }

  // 1.2
  def reverse(s: String): String =
    s.foldLeft("") { (acc, x) =>
      x.toString + acc
    }

}

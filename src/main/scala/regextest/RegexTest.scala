package regextest

import scala.util.matching.Regex

object RegexTest {
  def main(args: Array[String]): Unit = {
    val pattern1 = new Regex("[Ss]cala.*")
    val pattern2 = "(S|s)cala\\w*".r
    val str = "Scala is scalable and cool"
    val res = pattern2.findAllIn(str)
    println(res.mkString(","))

  }
}

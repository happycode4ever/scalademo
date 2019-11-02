package regextest

import scala.util.matching.Regex

object RegexTest {
  def main(args: Array[String]): Unit = {
    val pattern1 = new Regex("[Ss]cala.*")
    val pattern2 = "(S|s)cala\\w*".r
    val str = "Scala is scalable and cool"
    val res = pattern2.findAllIn(str)
    println(res.mkString(","))

    //匹配ip:host并且提取
    val host = "192.168.1.1:9300"
    val regex = "(.+):(\\d+)".r
    host match {
      case regex(ip,port) => println(ip,port)
    }
  }
}

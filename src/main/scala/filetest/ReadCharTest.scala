package filetest

import scala.io.Source

object ReadCharTest {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("pom.xml")
    //source默认保存的就是每个字符
    for(ch <- source)println(ch)
    source.close()
  }
}

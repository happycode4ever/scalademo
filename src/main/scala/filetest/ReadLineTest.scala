package filetest

import scala.io.Source

object ReadLineTest {
  def main(args: Array[String]): Unit = {
    //通过Source获取文件
    val source = Source.fromFile("pom.xml")
    //获取每行
    val lines = source.getLines()
//    val array:Array[String] = lines.toArray
    lines.foreach(println)
    //关闭资源
    source.close()
  }
}

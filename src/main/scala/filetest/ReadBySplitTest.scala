package filetest

import scala.io.Source

object ReadBySplitTest {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("info.csv")
    //读取整个文件作为字符串再以comma切割
    val strings = source.mkString.split(",")
    val str = strings.mkString("#")
    println(str)
  }
}

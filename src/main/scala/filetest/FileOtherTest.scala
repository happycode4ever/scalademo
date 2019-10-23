package filetest

import java.io.{File, PrintWriter}

import scala.io.{Source, StdIn}

object FileOtherTest {
  def main(args: Array[String]): Unit = {
//    readURL("https://www.baidu.com")
//    writeToFile("pw.out")
    readFromConsole()
  }

  //读取网络资源
 def readURL(url:String): Unit ={
   val source = Source.fromURL(url)
   println(source.mkString)
 }
  //写入文件
  def writeToFile(to:String)={
    //调用的还是Java的PrintWriter写出
    val pw = new PrintWriter(new File(to))
    for(i <- 1 to 100){
      pw.println(i)
    }
    pw.close()
  }
  //控制台输入
  def readFromConsole(): Unit ={
    println("请开始输入:")
    //Console方式已经过时
//    Console.readLine()
    val str = StdIn.readLine()
    println(s"输入的是:$str")
  }
}

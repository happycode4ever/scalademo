package implicittest

import java.io.File

import scala.io.Source

object ImplicitRichClassTest {
  //隐式转换拓展类功能
  implicit def FileToRichFile(file:File) = new RichFile(file)
  def main(args: Array[String]): Unit = {
    //File本身没有read函数 隐式转换成了自定义的RichFile才有了read
    new File("pom.xml").read
  }

}
class RichFile(from:File){
  def read = Source.fromFile(from).mkString
}

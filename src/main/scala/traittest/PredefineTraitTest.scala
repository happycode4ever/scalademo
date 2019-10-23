package traittest.predefine

object PredefineTraitTest {

}

import java.io.PrintStream

trait Logger7 {
  def log(msg: String)
}

trait FileLogger7 extends Logger7 {
  val fileName: String
  /*lazy*/ val out = new PrintStream(fileName)

  override def log(msg: String): Unit = {
    out.print(msg)
    out.flush()
  }
}

//构建类提前定义 定义类必须先继承，再将提前定义的内容混入实现的特质
class Predefine extends {
  override val fileName: String = "2019-09-15.log"
} with FileLogger7 {

}

class SavingsAccount7 {

}

object Main7 extends App {
  //不提前定义会造成空指针Exception in thread "main" java.lang.NullPointerException
  val acct1 = new SavingsAccount7 with FileLogger7 {
    override val fileName: String = "2019-09-15.log"
  }
  acct1.log("hahha")

  //提前定义 只有复写字段才能提前定义

  //1.通过结构类型动态提前定义抽象属性
//  val acct2 = new {
//    override val fileName = "2019-09-15.log"
//  } with FileLogger7
//  acct2.log("heiheihei")

  //2,通过创建类的方式提前定义
//  private val acct3 = new Predefine
//  acct3.log("xixiix")

  //3.使用到子类对象的属性的方法懒加载
}
package traittest.dynamicwith

import java.time.LocalDate

object DynamicWithTraitTest {
  def main(args: Array[String]): Unit = {
    //单个特质混入 在构建抽象类的基础上动态混入需要实现的特质
    val accout = new Accout() with ConsoleLogger
    accout.withDraw(100)
    //直接使用匿名内部类
//    val account2 = new Accout {
//      override def log(msg: String): Unit = println(msg+"11111")
//    }
//    account2.withDraw(100)
    //多个特质混入如果都实现了同一个抽象方法只走最右边的特质，后面的覆盖了
  val accout3 = new Accout() with ConsoleLogger with DateLogger
  accout3.withDraw(100)
  }
}
//带有抽象方法的特质
trait Logger{
  def log(msg:String)
}
//具体实现的特质
trait ConsoleLogger extends Logger{
  //要使用alt+ins生成implement方法
 override def log(msg:String) = println(s"consolelogger msg=$msg")
}
trait DateLogger extends Logger{
  override def log(msg: String): Unit = println(s"DateLogger ${LocalDate.now()} msg=$msg")
}

//基础父类
class Balance{
  protected var balance = 0.0
}
//部分实现的抽象类
abstract class Accout extends Balance with Logger{
  def withDraw(amount:Double)={
    if(balance < amount)log("余额不足")
    else balance -= amount
  }
}


package traittest.dynamicmulti

import java.time.LocalDate

object DynamicMultiTraitTest {
  def main(args: Array[String]): Unit = {
    //混入多个特质都继承同一个实现的特质 从右往左执行特质，最后走父实现的特质
    //顺序是 time,date,console
    val accout1 = new Accout with LocalDateLogger with TimestampLogger
    accout1.withDraw(100)
    //顺序是 date.time,console
    val accout2 = new Accout with TimestampLogger with LocalDateLogger
    accout2.withDraw(100)

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
//实现特质子特质1
trait LocalDateLogger extends ConsoleLogger{
  override def log(msg: String): Unit = {
    super.log(LocalDate.now()+":"+msg)
  }
}
//实现特质的子特质2
trait TimestampLogger extends ConsoleLogger{
  override def log(msg: String): Unit = super.log(System.currentTimeMillis()+":"+msg)
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

//定义类必须先继承再混入 如果是new的方式则可以直接混入
// abstract class Accout extends Logger{
//  var balance = 0.0
//  def withDraw(amount:Double)={
//    if(balance < amount)log("余额不足")
//    else balance -= amount
//  }
//}
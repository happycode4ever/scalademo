package traittest.abstractoverride

import java.time.LocalDate

object AbstractOverrideTraitTest {
  def main(args: Array[String]): Unit = {
    val account = new Account with ConsoleLogger with TimestampLogger with DateLogger
    //注意初始化抽象类混入特质时，最左跟随的特质必须是具体实现的特质，后面的特质还是按照右往左的顺序执行super
    //特别注意super关键字不能漏 否则栈溢出错误
//    val account = new Account with TimestampLogger with ConsoleLogger with DateLogger
    account.withDraw(100)
  }
}
trait Logger{
  def log(msg:String)
}

trait TimestampLogger extends Logger{
  abstract override def log(msg: String): Unit = {
    //特质并没有具体实现父特质的抽象所以还是抽象方法
   super.log(System.currentTimeMillis() + ":" + (if(msg.length <10)msg else msg.substring(0,5)))
 }
}

trait DateLogger extends Logger {
  //特质并没有具体实现父特质的抽象所以还是抽象方法
  abstract override def log(msg: String): Unit = super.log(LocalDate.now()+":"+msg)
}

trait ConsoleLogger extends Logger{
  override def log(msg: String): Unit = println(msg)
}

abstract  class Account extends Logger{
  var balance  = 0.0
  def withDraw(amount:Double): Unit ={
    if(balance < amount) log("余额不足")
    else balance -= amount
  }
}

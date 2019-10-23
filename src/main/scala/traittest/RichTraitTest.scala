package traittest.richtrait

object RichTraitTest {
  def main(args: Array[String]): Unit = {
    new Account with ConsoleLogger
  }
}
trait Logger{
  //抽象方法
  def log(msg:String)
  //非抽象方法引用抽象方法 编译可以通过 因为可以动态混入
  def info(msg:String) = log(s"INFO: $msg")
  def warn(msg:String) = log(s"WARN: $msg")
  def error(msg:String) = log(s"ERROR: $msg")

}

trait ConsoleLogger extends Logger{
  override def log(msg: String): Unit = println(s"consoleLogger $msg")
}

abstract class Account extends Logger{
  super.warn("余额不足")
}


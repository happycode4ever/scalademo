package traittest.simpletrait

object SimpleTraitTest{
  def main(args: Array[String]): Unit = {

  //  new ConsoleLogger().log("afadfaf")

    new A with Logger{
      override def log(msg: String): Unit = println(s"$msg anonymity")
    }.log("hello")


  }
}
trait Logger{
  def log(msg:String)
}
//Class A needs to be trait to be mixed in 混入的只能是特质
//必须先继承才能混入
class ConsoleLogger extends Logger /*with Serializable with Cloneable*/ /*with A*/{
  override def log(msg: String): Unit = println(msg)
}
class A

package traittest.fieldtrait

object FieldTraitTest extends App {
  new Account("hello") {
    override def log(msg: String): Unit = println(msg)
  }
}
trait Logger{
  //特质具体字段
  val field = 10
  //特质抽象字段
  val abstractField:String
  def log(msg:String)
}
abstract class Account(name:String) extends Logger{

  override val abstractField: String = name
  //**注意super.log的使用前提是父类已经实现了方法 抽象的不能用super
  //除非定义一个方法和父类的方法相同才在方法体内使用super.log 注意只有特质才能标明abstract override def log()

  log(abstractField+":"+field)

}

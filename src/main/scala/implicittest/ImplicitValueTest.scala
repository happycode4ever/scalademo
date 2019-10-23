package implicittest

object ImplicitValueTest {
//  def person(implicit name:String) = name
//  implicit val name = "hello"

  //不能存在多个同类型的隐式变量 产生二义性
  //隐式值必须在所在代码块附近定义 否则找不到
  implicit val name2 = "hello2"
  def main(args: Array[String]): Unit = {
    println(new Person().work)
  }
}
class Person{
  //类中定义的隐式值不起作用
//  implicit val name = "hello"
  def work(implicit name:String) = name
}


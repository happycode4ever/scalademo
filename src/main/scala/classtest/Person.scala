package classtest

//主构造器不加val/var 只能在声明类中使用，外部使用并没有该成员
//如果加了则生成该成员 val则不能改变成员的值
class Person (var name:String,val age:Int) {
  println(name+","+age)
  def getInfo = {
    println(name + ":"+ age)
  }
}
object Person{
  def main(args: Array[String]): Unit = {
    val person = new Person("hello",1111)
    val name = person.name
    person name_= "hi"
    println(name)
    person.getInfo
  }
}

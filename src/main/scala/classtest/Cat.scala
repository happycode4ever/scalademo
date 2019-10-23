package classtest

class Cat(`type`:String,age:Int) extends Animal(`type`,age) {
  private val leg = 10
  //val 只能重写父类公有的val不能重写私有的 或者重写无参的def
  //var 只能重写抽象父类的var
  //def重写def
//  override val school:String = "1111"
  //可以通过super.获取父类的成员
//  def getPartent={
//    println(super.school)
//    println(age)
//  }

//  Cat.leg
override def toString = s"Cat($leg, $name)"
}
object Cat extends App{
  val cat = new Cat("hello",1)
  println(cat)
  private val leg = 4
  println(Cat.leg)
}

package classtest.supertest

object SuperTest extends App {
  private val son = new Son(10)
  println(son.getFatherAttr)
  println(son.getSonAttr)
//  println(son.attr)
}
class Father(val attr:Int = 0){
  println(s"father $attr")
  def getFatherAttr = attr*2
}
//**注意不能通过super关键字获取父类字段编译会报错
//可以同时存在
class Son(attr:Int) extends Father(30) {
  println(s"son $attr")

  def getSonAttr = super.getFatherAttr * 3

}
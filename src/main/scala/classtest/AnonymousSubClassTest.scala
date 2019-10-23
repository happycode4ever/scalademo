package classtest.anonymous

object AnonymousSubClassTest extends App {
  //匿名子类
  val son = new Father(111){
    override def work(name: String): Unit = {
      super.work(name)
      println(id+name.toUpperCase)
    }
  }
  son.work("jack")
}
class Father(val id:Int){
  def work(name:String)={
    println(name+id)
  }
}

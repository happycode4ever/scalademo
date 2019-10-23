package collection

object MatchTest {
  def main(args: Array[String]): Unit = {
    val a=2
    val obj={
      if(a==1) List[Int](1)
      else if(a==2)List[String]("aa")
    }
    println(obj)
    obj match {
      case x:List[Int] => println("List[Int]")
      case x:List[String] => println("List[String]")
      case _ => println("other")
    }
    println(obj+","+obj.getClass.getCanonicalName)

    val arr = Array(1,2,3,4)
    arr match {
      case Array(x,y @ _*) =>println(x,y)
    }
  }
}

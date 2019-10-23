package matchmode

object GuardTest {
  def main(args: Array[String]): Unit = {
    val a = "fafaf"
    var result = 0
    a match {
      case x if(a.toString.matches("\\d+")) => println(a+","+x)
      case _ if(a.toString.matches("[a-zA-Z]+")) => println(a+" is word")
      case _ => result = 111
    }
    println("result="+result)
  }
}

import scala.util.control.Breaks

object HelloWorld {
  import scala.math._
  def main(args: Array[String]): Unit = {
    println("hello")
    var a = 100
    val b = sqrt(a)
    println(b)
    val arr = Array(1,2,3)
    arr(2)=10
    println(arr(2))
    new Breaks
  }
}

package control

import scala.util.control.Breaks

object WhileTest {
  def main(args: Array[String]): Unit = {
    //while一定没有返回值 返回的是Unit也就是()
    var a = 0
    val res = while(a<=10){
      println(a)
      a+=1
      10
    }
    println(res)
    var b = 0
    val looper = new Breaks
    looper.breakable {
      while (true) {
        b+=1
        println("b="+b)
        if (b == 10) {
          //break操作需要导包breaks
          looper.break()
        }
      }
    }
  }
}

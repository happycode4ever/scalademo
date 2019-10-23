package control

object IfElseTest {
  def main(args: Array[String]): Unit = {
    //if else 一定有返回值
    val a = 10
    val res = if(a>=10) "a>=10" else -1
    println(res)
    val res2 = if(a>=10) println(1) else println(-1)
    println(res2)
  }
}

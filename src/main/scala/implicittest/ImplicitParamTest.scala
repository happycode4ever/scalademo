package implicittest

object ImplicitParamTest {
  //拓展隐式参数的功能 提供一个smaller的方法

  def main(args: Array[String]): Unit = {
    def smaller[T](a:T,b:T)(implicit order: T => Ordered[T]) = if (a<b) a else b

    val s = smaller(1,2)
    println(s)
    val s2 = smaller("wqee","ffeq3")
    println(s2)
  }
}

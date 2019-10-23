package implicittest

object SimpleImplicit {
//  implicit def a(d:Double) = d.toInt
  def main(args: Array[String]): Unit = {
      implicit def a(d:Double) = d.toInt
    val i:Int = 10.5//如果隐式转换没有 会编译报错 隐式转换自动执行
    println(i)
  }
}

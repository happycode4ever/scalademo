package classtest.predefine

object PreDefindTest {
  def main(args: Array[String]): Unit = {
    val son = new Son()
    val range = son.range
    val length = son.arr.length
    println(s"$range $length")
    println("--------------------")
    //提前定义 通过定义类的形式 class son extends {override} with FFFF
    val son2 = new FixSon()
    val range2 = son2.range
    val length2 = son2.arr.length
    println(s"$range2 $length2")
    println("--------------------")
    //动态提前定义 通过new动态填充复写的字段 只有复写字段才能提前定义 new {override} with FFFF
        val son3 = new {
          override val range: Int = 30
        }with Father
        println(s"${son3.range} ${son3.arr.length}")

    println("--------------------")
    //提前定义必须写在父类前面不然没效果
    val son4 = new {} with Father{
      override val range: Int = 30
    }
        println(s"${son4.range} ${son4.arr.length}")

  }
}
class Father{
  val range = 10
  //先执行父类初始化发现range被重写 而子类还没初始化 所以range默认值是0 导致取值错误
  println(s"father $range")
  val arr = new Array[Int](range)
}

class Son extends Father{
  override val range: Int = 30
  println(s"son $range")
}

//extends 后面将要复写的内容填充并且混入父类就可以提前定义防止拿不到子类的内容
class FixSon extends {
  override val range: Int = 30
}with Father
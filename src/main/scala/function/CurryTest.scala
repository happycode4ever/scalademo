package function

object CurryTest {
  def main(args: Array[String]): Unit = {
    val arr1 = Array("hello","scala")
    val arr2 = Array("HellO","SCala")
    val strings = Array("HellO","SCala")
    //correspond作用 seq对象的方法接收另一个seq对象 再对两个对象里的每个元素应用函数的方法返回的布尔值判断结果
    val res = arr1.corresponds(arr2)((x,y)=> x.equalsIgnoreCase(y))
    println(res)
  }
}

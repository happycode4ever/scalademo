package genericitytest

object GenericityClassTest {

  def main(args: Array[String]): Unit = {
    //从构造参数推断类型
    val p1 = new Pair(42, "String")
    //设置类型
    val p2 = new Pair[Any, Any](42, "String")
  }
}
//泛型类
class Pair[T, S](val first: T, val second: S) {
  override def toString = "(" + first + "," + second + ")"
}



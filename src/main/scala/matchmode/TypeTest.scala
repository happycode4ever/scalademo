package matchmode

object TypeTest {
  def main(args: Array[String]): Unit = {
    val a = 1
    val obj = if(a == 1) 1
    else if(a == 2) "2"
    else if(a == 3) BigInt(3)
    else if(a == 4) Map("aa" -> 1)
    else if(a == 5) Map(1 -> "aa")
    else if(a == 6) Array(1, 2, 3)
    else if(a == 7) Array("aa", 1)
    else if(a == 8) Array("aa")
    val r1 = obj match {
      case x: BigInt => x
      case s: String => s.toInt
      case _:Int => -1 //不能这么匹配 case Int => -1 一定要指定 x:type 如果用不上x可以用_代替
      case _: BigInt => Int.MaxValue
        //**注意对于map，list，set这类集合在java有的泛型 为了向下兼容，scala编译会丢掉类型所以只会中第一条匹配的case
      case m: Map[String, Int] => "Map[String, Int]类型的Map集合"
      case m: Map[_, _] => "Map集合"
      case a: Array[Int] => "It's an Array[Int]"
      case a: Array[String] => "It's an Array[String]"
      case a: Array[_] => "It's an array of something other than Int"
      case _ => 0
    }
    println(r1 + ", " + r1.getClass.getName)
  }
}

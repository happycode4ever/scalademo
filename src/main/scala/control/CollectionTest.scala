package control

object CollectionTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
    val str = arr.mkString(" ")
    println(str)
    val map = Map("name"->"mary","age" -> 30)
    println(map)
    //get获得的是option对象
//    如果有值是some类型，没值是none类型
    val option1 = map.get("name")
    val option2 = map.get("sex")
    println(option1.get)
//    println(option2.get)//sex不存在是none类型会抛出NoSuchElementException
//    如果直接用Map的apply是none也会抛出此异常
    println(map("name"))
    println(map("sex"))
  }
}

package classtest

object EnumTest {
  def main(args: Array[String]): Unit = {
    println(Color.values)
  }
}

/**
  * 自定义标准枚举 留坑学习复杂枚举
  */
object Color extends Enumeration{
  val RED = Value(1,"red")
  val GREEN = Value(2,"green")
  val YELLOW = Value(3,"yellow")
}

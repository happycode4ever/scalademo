package classtest

class CastTest {

}
object CastTest{
  def main(args: Array[String]): Unit = {
    val `class` = classOf[CastTest]//获取类型class classtest.CastTest
    println(`class`)//如何获取类类型?
//    println()
    val bool = "hello".isInstanceOf[String]//判断类型 相当于java的instanceOf
    println(bool)
    val d = 10.0
    val i = d.asInstanceOf[Int]//相当于java的强制类型转换cast
    println(i)
  }
}

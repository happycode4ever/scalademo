package typetest

object DiffTest {
  def main(args: Array[String]): Unit = {
    import scala.reflect.runtime.universe._
    //type是描述class的类型
    val v1 = typeOf[A]
    //Java原生方式获取的是A及其子类型
    val v2 = new A().getClass
    //Scala方式获取的是基准类型
    val v3 = classOf[A]
    println(v1,v2,v3)
  }
}
//class A

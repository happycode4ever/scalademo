package classtest.abstracttest

object AbstractTest {
  def main(args: Array[String]): Unit = {
    val son = new Father {
      val leg = 4
      override val age: Int = 10

      override def work(name: String): Unit = println(name+leg)

      override def toString: String = leg+","+age+","+name
    }
    println(son)
    son.work("hahahah")
  }

}
abstract class Father{
  val name = "hi"
  val age:Int
  def work(name:String)
}

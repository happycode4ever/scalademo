package classtest.innerclass

object InnerTest {
  def work: Unit ={
    class My{
      def say(str:String){println(str)}
    }
    new My().say("hello")
  }

  def main(args: Array[String]): Unit = {
    work
  }
}

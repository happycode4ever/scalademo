package matchmode

object SwitchTest {
  def main(args: Array[String]): Unit = {
    val a = 3
    a match {
      case 1 => println("1")
      case 2 => println("2")
        //注意一定要匹配全不然会报MatchError
      case _ => println("other")
    }
  }
}

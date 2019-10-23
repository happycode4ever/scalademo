package matchmode

object MatchToValTest {
  def main(args: Array[String]): Unit = {
    //**BigInt专属运算 /%求商和余数
    val (x,y) = BigInt(10) /% 3
    println(s"x=$x y=$y")
    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr
    println(first, second)
  }
}

package control

import scala.util.control.Breaks


object BreakTest {
  def main(args: Array[String]): Unit = {
    val loop1 = new Breaks()
    val loop2 = new Breaks()
    loop1.breakable {
      for (i <- 1 to 100) {
        println(s"i=$i")
        loop2.breakable {
          for (j <- 0 to i) {
            println(s"j=$j")
            if (i * j == 100) {
              println(s"$i => $j")
              loop1.break()
            }
          }
        }
      }
    }
  }
}

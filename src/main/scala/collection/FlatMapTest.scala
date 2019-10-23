package collection

object FlatMapTest {

  def flatMap1(): Unit = {
    val li = List(1,2,3)
    val res = li.flatMap(x => x match {
      case 3 => List(List('a', 'b'))
      case _ => List(x*2)
    }).map((_,1))
    println(res)
  }

  def main(args: Array[String]): Unit = {
    flatMap1()
  }
}

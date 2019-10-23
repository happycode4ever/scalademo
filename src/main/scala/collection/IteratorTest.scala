package collection

object IteratorTest {
  def main(args: Array[String]): Unit = {
    val iterator = (1 to 10).iterator
    while(iterator.hasNext)println(iterator.next)
  }

}

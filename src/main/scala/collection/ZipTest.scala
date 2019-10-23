package collection

import scala.collection.mutable

object ZipTest {
  def main(args: Array[String]): Unit = {
    val l1 = List("Hello")
    val l2 = List("Scala")
    val map = mutable.Map[String,String]()
    val tuples = l1 zip l2
    for(e <- tuples){
      //这里的map可以添加元组 普通的方式不行
      map += e
      println(e)
    }
    println(map)
  }
}

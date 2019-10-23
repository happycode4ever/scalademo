package collection

object TupleTest {
  def main(args: Array[String]): Unit = {
    val tuple = (1,24f,"dgfd",10.0,245245)
    //tuple._x方式提取第几个参数，有几个参数其实就是tuplex类型
    val value = tuple._4
    println(value)
    //tuple元组定义好就不能再改变了
    //普通遍历方式
    for(o <- tuple.productIterator){
      println(o)
    }
    //高级遍历方式
    tuple.productIterator.foreach(println(_))
    tuple.productIterator.foreach(i => println("获取元素:"+i));
  }
}

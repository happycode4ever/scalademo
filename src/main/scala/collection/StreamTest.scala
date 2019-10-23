package collection

object StreamTest {
  def main(args: Array[String]): Unit = {
    def f(n: Int):Stream[Int]= {
      (2*n-1) #:: f(n+1)//:: 是 collection 中常用的连接数据的方法。而 #:: 表示是连接数据但是是延迟执行的，左往右拼接
    }

    val stream = f(1)
    println(stream)
    println(stream.head)
    println(stream.tail)//stream.tail会触发生成新的stream
    println(stream.tail.tail)
    val stream1 = stream.tail
    val stream2 = stream1.tail//tail也会触发原stream执行
    println(stream1)
    println(stream2)
    println(stream.take(10))
    //可以通过take提取前n个的执行结果
    val list = stream.take(10).toList
    println(list)
  }
}
package annotationtest

import scala.annotation.tailrec

object TailRecursiveTest {
  //尾递归解释：进入下一个函数不再需要上一个函数的环境了，得出结果以后直接返回
  //求和一个序列，由于后续递归的函数需要依赖head做运算，不是单纯的尾递归
  def sum(seq:Seq[Int]):Int={
    if(seq.length==0)0
    else seq.head+sum(seq.tail)
  }
  //尾递归优化，不依赖上一次的head，作为参数传递，减少内存消耗
 @tailrec def sum(head:Int, seq:Seq[Int]):Int={
    if(seq.length==0)head
      //修改为之前和head和当前的head叠加作为下一次的head
    else sum(head+seq.head,seq.tail)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
    val i1 = sum(arr)
    println(i1)
    val i2 = sum(0,arr)
    println(i2)
  }
}


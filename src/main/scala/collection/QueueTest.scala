package collection

import scala.collection.immutable.Queue
import scala.collection.mutable

object QueueTest {
  def mutableQueueTest = {
    val q1 = mutable.Queue(1,"2")
    //入队
    q1.enqueue(33,1351.0,"dafdafdf")
    q1 += 100
    println(q1)
    //先进先出
    q1.dequeue()
    println(q1)
    //可以增删改值
    q1(1)=4
    println(q1)
    //拿头部元素 尾部元素 以及除了第一的元素 并没有改变当前队列
    println(q1.head)
    println(q1.last)
    println(q1.tail)
  }
  def immutableQueueTest={
    val q2 = Queue(1,"13431",134.124)
    //非可变队列入队会产生新的queue
    val q3 = q2.enqueue("aaa")
    println(q2.hashCode())
    println(q2)
    println(q3.hashCode())
    println(q3)
    val q4 = q3 :+ (11,22)
    println(q4.hashCode())
    println(q4)
  }
  def main(args: Array[String]): Unit = {
//   mutableQueueTest
    immutableQueueTest
  }
}

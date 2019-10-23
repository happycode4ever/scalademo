package collection

import scala.collection.mutable.ListBuffer


object ListTest {
  def compare: Unit ={
    val l1 = List(1,2,3,3,4,5,5)
    val l2 = List(3,4,7,8,8,9)
    //l1和l2交集并去重
    val l3 = l1.intersect(l2)
    println(l3)
    //l1和l2并集并且去重
    val l4 = (l1 ++ l2).distinct
    //l1-l2的差集没有去重
    val l5 = l1.diff(l2)
    println(l4)
    println(l5)
    val max = l4.max
    //也可以通过转成set的方式
    val set = l5.toSet
    println(max)

  }
  def declare: Unit ={
    val list1 = List(1,2,3)
//    updated不能超过原有list的大小
//        val list2 = list1 updated(3,5)
    val list2 = List(3,4,5,6)
    val list22 = list1 ++ list2
    println(list2)
    println(list22)
    val list3 = ListBuffer[Any]()
    //追加元素方式 append或者+=添加元素
    list3.append(111,1222)
    list3 += 44
    //-=可以删除元素
    list3 -= 44
    println(list3)
    //以下两种方式都会生成新的对象
    //++=或者:+适用于可变list如ListBuffer所以最左必须是ListBuffer
    val list4 = list3 ++= list2 :+ list1
    //::适用于不可变list从右往左,所以最右必须是不可变类型List ::和+:相同
    //同理:::是从左往右合并
    // **区别：:::但是会提取list里的元素合并 ::或者:+会将第二个list作为整个参数合并
    val list5 =list2 :: list2 ::: list1 :: List(20,20)
    println(list3)
    println(list4)
    println(list5)
  }

  def main(args: Array[String]): Unit = {
  declare
//  compare
  }
}

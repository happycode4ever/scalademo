package collection

import scala.collection.mutable

object SetTest {
  def immutableSet={
    val s1 = Set[Any](1,2,3)
    //set无序无法按照角标取值
    //apply方法获取的是否存在这个元素
    val bool = s1(11)
    println(bool)
    //不可变set可以增删元素
    val s2 = s1 + ("aaa",12.0)
    println(s2)
    val s3 = s2 - "aaa"
    println(s3)
  }
  def mutableSet={
    import mutable.Set
    val s1 = Set(1,2,3)
    //可以通过update方式增删元素 true是add false是remove
    s1.update(3,false)
    s1 += (44,55,66)
    s1 -= 44
    s1.add(66)
    s1.remove(66)
    val s2 = s1 + 4
    println(s1)
    println(s2)
    //&交集 &~差集 ++并集
    val s4 = s2 ++ s1
    println(s4)
    //交集
    val ss1 = s2.intersect(s1)
    //差集 s2-s2
    val ss2 = s2.diff(s1)
    //并集
    val ss3 = s2.union(s1)
  }

  def main(args: Array[String]): Unit = {
//    immutableSet
    mutableSet
  }
}

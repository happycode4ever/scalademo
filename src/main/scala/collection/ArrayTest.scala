package collection

import scala.collection.mutable.ArrayBuffer

object ArrayTest {
  def immutableArr() = {
    //不可变数组 必须指定类型 不然是Nothing类型 编译报错
    //如果指定Any类型默认值是null,相当于转换成了java的Object
    //1.创建
    val arr = new Array[Int](10)
    val arr2 = Array(1,2,3)
    //2.赋值
    arr(1)=1
    arr.update(2,20)
    //3.获取值
    val i = arr.apply(1)
    val j = arr(1)
    println(i+","+j)
    println(arr.mkString("#"))
    println(arr2.mkString("$"))
    println(arr.hashCode())
    println(arr2.hashCode())
    //4.追加是生成新的数据
    val arr3 = arr2++arr
    println(arr3.mkString("#"))
    println(arr3.hashCode())
  }
  def mutableArr(): Unit ={
    //1.创建 可以空参 直接打印对象是ArrayBuffer里的值
    val ab1 = ArrayBuffer[Int]()
    val ab2 = ArrayBuffer[Int](1,2,3)
    println(ab1)
    println(ab1.hashCode())
    //2.赋值 和不可变的方式一样
    ab2.update(1,10)
    ab2(2)=5
    println(ab2)
    println(ab2.hashCode())
    //3.获取值
    val i = ab2.apply(1)
    val j = ab2(2)
//    ab2.applyOrElse()
    println(i+","+j)
    //4.追加
    ab2.append(50)
    println(ab2)
    println(ab2.hashCode())
    //和不可变数组一样这种方式聚合的是新的数组
    val ab3 = 222 +: ab2
    println(ab3)
    println(ab3.hashCode())

    //可变集合可以通过+=添加元素 ++=添加集合 :+将集合作为一个元素添加
    ab2 += 111
    ab2 -= 111
    println(ab2)

    ab2 ++= ab3
    println(ab2)

  }
  def dimArray()={
    //创建二维数组
    val arr = Array.ofDim[Int](3,4)
    //赋值
    arr(1)(2)=1
    //遍历
    for(x <- arr)println(x.mkString(","))
    //追加
    val arr2 = arr:+Array(1,2)
    for(x <- arr2)println(x.mkString("#"))
  }

  def removeArrTest: Unit ={
    val arr = ArrayBuffer(1,11,22,33,22,11,1,5,6)
    arr -= (22,22)
    println(arr.mkString(","))
  }

  def main(args: Array[String]): Unit = {
//    immutableArr
//    mutableArr
//    dimArray()
    removeArrTest
//    val arr = Array(1,2,3) ++ Array(2,3,4)
//    println(arr.mkString(","))
  }
}

package collection

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object MapTest {
  def main(args: Array[String]): Unit = {
    val map1 = Map("a" -> 10, "b" -> 20, 21 -> 30)
    //**map的updated可以用于新增和修改
    val map12 = map1.updated("d",11)
    println(map12)
    //不可变map增删元素方式用 + -生成新的map +必须用键值对 -用的是元组表示要删除的key
    val map11 = map1 + ("a"->20.0) - 10
    //++可以合并map--必须是对应key的集合
    val map112 = map1 ++ map12 -- List("a","b")
    println("map112:"+map112)
    val map2 = map1 updated("c", 2)
    val map3 = mutable.Map[Any,Any](("Alice", 1),"2" -> 2)
    //可变Map的2种添加键值对形势
//    map3.put("hello", "hey")
    map3.+=("1"->"111")
    //删除的是key可以用元组包含
    map3 -= "2"
    println(map3)
    val map4 = map3 ++= map1
    println(map4)
    //取值 直接用apply方式可能会抛异常
    val v = map4("Alice")
    println(v)
    //可以通过get转换成option的方式则不会抛异常 或者在map就contains判断key存在再取值
    val v2 = map4.get("Alice").get
    println(v2)


    //遍历
    for ((k, v) <- map4) {
      println("k=" + k + ",v=" + v)
    }
    println("----------------")
    for (k <- map4.keys) println(k)
    for (v <- map4.values) println(v)
    //实际上每个map的元素都是tuple2
    for (m <- map4) println(m)
    //**高阶函数使用
    map4.foreach(println(_))

    val strings = new ArrayBuffer[String]()
    strings += "1,2,3,4,5,6"
    strings += "11,21,31,41,51,61"
    strings += "12,22,32,42,52,62"
    //第一次map遍历ArrayBuffer的每个字符串映射成数组返回成ArrayBuffer[Array[String]]
    val stringsmap1 = strings.map(_.split(","))
    //第二次map取到的就是每个数组对象再遍历处理回ArrayBuffer[String]
    val stringsmap2 = stringsmap1.map(x=>x.mkString("#"))
    println(stringsmap1)
    println(stringsmap2)

  }
}

package collection

import scala.collection.mutable

object MapReduceFoldScanTest {
  private val list = List(1,2,3,4,5)
  private val strlist = List("hello","Scalc","Now")
  def mapTest: Unit ={
    //map映射集合的每个元素调用传入的方法收集返回值封装回集合返回
    val list = strlist.map(x => x.toUpperCase)
    println(list)
    //扁平化成每个字符再转大写 _只能使用一次如果对字符有别的操作就不可使用
    val chars = strlist.flatMap(_.toUpperCase)
    println(chars)
  }

  def reduceTest: Unit ={
    val sum = list.reduceLeft((sum,x)=>sum-x)//1-2-3-4-5
    println(sum)
    //每一个_都对应入参的占位符对应的位置的元素
    //def reduceLeft[B >: A](f: (B, A) => B): B 第一个_对应B 第二个_对应A 如果是按顺序操作的可以简写
    println(list.reduceLeft(_-_))//_对应sum _对应x才可以简写
    val sum2 = list.reduceRight((x,sum) => x-sum)//1-(2-(3-(4-5)))
    println(sum2)
    println(list.reduceRight(_-_))//_对应x _对应sum才可以简写

    //**reduce方法看不懂
  }
  def foldTest: Unit ={
    //fold第一个参数多了个初始值填充sum的位置
    val sum1 = list.foldLeft(1)((sum,x)=>sum-x)//0-1-2-3-4-5
    val sum11 = (1/:list)(_-_)//init/:list 是foldLeft简写的形式
    println(sum1)
    println(sum11)
    val sum2 = list.foldRight(-11)((x,sum)=>{//1-(2-(3-(4-(5--11))))
      println("x="+x+",sum="+sum)
      x-sum
    })
    val sum22 = (list:\(-11))(_-_)//list:\init是foldRight的简写形式
    println(sum2)
    println(sum22)
  }

  def scanTest: Unit ={
    //定义一个初始值 然后每次运算的结果sum存到集合里
    list.scanLeft(0)(_-_).foreach(println(_))
  }

  def wcTest: Unit ={
    val sentence = "一首现代诗《笑里藏刀》:哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈刀哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"

    //选型用foldLeft
    //1初始一个Map[Char,Int]接受每个字符的统计
    //Array[Char]foldLeft(Map[Char,Int])(())
    //2统计每个字符的个数是1追加到上一个map中
//    val value = (Map[Char,Int]()/:sentence)((map, char) => map + (char -> 1))
    //3由于上一个map可能没有这个字符，所以在map里找到这个字符就拿到结果+1追加回map替换，找不到默认就是0
    //**注意(map.getOrElse(char,0) + 1)这部分结果要包起来不然报错
    val resultMap = (mutable.Map[Char,Int]()/:sentence)((map, char)=>map + (char -> (map.getOrElse(char,0) + 1)))
    println(resultMap)
  }

  def main(args: Array[String]): Unit = {
//    mapTest
//    reduceTest
//    scanTest
//    foldTest
    wcTest
  }
}

package matchmode

object SampleTest {
  def baseTest: Unit ={
    val dollar = Dollar(10.0)
    val currency = Currency(100.0, "RMB")
    val arr = Array(dollar,currency)
    for(e <- arr){
      val result = e match {
        case Dollar(v) => "$"+v
        case Currency(v,u) => u + v
      }
      println(e+":"+result)
    }
    //可以拷贝对象修改值生成新的对象
    val dollar1 = dollar.copy(1000.0)
    println(dollar)
    println(dollar1)
    val currency2 = currency.copy(10.0,"USD")
    println(currency)
    println(currency2)
    //中置表达式的抽取器 抽取不完的都会封装进最后一个元素里
    val xs = 58 #:: 43 #:: 93 #:: Stream.empty
    xs match {
      case first #:: second #:: _ => println(first - second)
      case _ => println(-1)
    }
    println(xs)
    val list = 1 :: 2 :: 3 :: 4 :: Nil
    list match{
      //rest 结果是List(3,4)
      case first :: second :: rest => println(s" $first $second $rest")
      case _ => println("none match")
    }
  }

  def advanceTest: Unit ={
    val sale = Bundle("愚人节大甩卖系列", 10,
      Article("《九阴真经》", 40),
      Bundle("从出门一条狗到装备全发光的修炼之路系列", 20,
        Article("《如何快速捡起地上的装备》", 80),
        Article("《名字起得太长躲在树后容易被地方发现》",30)))

    //拿到第一个Article的值
    val result1 = sale match {
      case Bundle(_,_,art @ Article(title,price),_*) => art+","+title+","+price
    }
    println(result1)

    //拿到剩余bundle数组
    val result2 = sale match {
        //注意rest @ _*得到的是WrappedArray[Bundle]类型
      case Bundle(_, _, art @ Article(_, _), rest @ _*) => (art, rest)
    }
    println(result2)

    //拿到剩余bundle对象
    val result3 = sale match {
        //如果直接用变量接受直接是拿到Bundle类型
        //注意不能直接拿items不然报MatchError
      case Bundle(series, discount, _, items) =>items
    }
    println(result3)

    //**计算结果 设计递归函数
    def recursiveSum(item:Item):Double={
      item match {
          //如果是Article对象提取price
        case art @ Article(_,price) =>{
          println(s"$art 提取price= $price")
          price
        }
          //注意一定要用items @ _*的方式提取成数组对象才能用map
          //如果是Bundle对象提取discount，后续的Bundle作为每个item执行统计操作最后减掉折扣
        case Bundle(_, discount,items @ _*) => {

          val map = items.map(recursiveSum(_))
          println(s"$map 开始执行递归")
          val sum = map.sum
          println(s"$sum - $discount = ${sum-discount}")
          sum-discount
        }

       }
    }
    recursiveSum(sale)
  }

  def enumTest: Unit ={
    sealed abstract class Color
    case object Red extends Color
    case object Green extends Color
    case object Yellow extends Color

    val colors = Array(Red,Green,Yellow,"dfda")
    for (c <- colors){
      c match {
        case Red => println("red")
        case Green => println("green")
        case Yellow => println("yellow")
        case x:String => println(x)
      }
    }
  }

  def main(args: Array[String]): Unit = {
//    advanceTest
    enumTest
  }

}
//密封类的子类必须在本文件中声明
sealed abstract class Item
case class Article(title:String, price:Double) extends Item
case class Bundle(series:String,discount:Double,items:Item*) extends Item

//abstract class Amount
//{
//  case class Dollar(value: Double) extends Amount
//  case class Currency(value: Double, unit: String) extends Amount
//}
//**case class 反编译结果就是默认生成了object下的apply和unapply方法
//将生成toString、equals、hashCode和copy方法——除非显式地给出这些方法的定义
// public com.mobin.scala.Person apply(java.lang.String, int);
// public scala.Option<scala.Tuple2<java.lang.String, java.lang.Object>> unapply(com.mobin.scala.Person);
case class Dollar(d:Double)
case class Currency(value: Double, unit: String)

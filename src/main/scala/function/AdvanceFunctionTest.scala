package function

object AdvanceFunctionTest {

  //高阶函数 参数是函数 函数体里回调函数
  def f1(x:Int,y:Int,f:(Int,Int) => Double):Double={
    f(x,y)
  }

  //最右边函数可以用到左边函数的参数就称之为闭包
  def f2(x:Int) = (y:Int) => x+y

  //柯里化衍生 如果定义成这样必须传两个入参
  def f3(x:Int)(y:Int) = x+y

  def main(args: Array[String]): Unit = {
    val d = f1(10,20,(x,y) => x*y)
    println(d)
    val funtion1 = f2(10)
    val res = funtion1(20)
    println(s" $funtion1 $res ${f2(10)(20)}")
    println(f3(10)(20))
  }
}

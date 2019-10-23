package function

object FunctionTest {
  def main(args: Array[String]): Unit = {
    def play(a1:Int,a2:Int):Int={
      if(a1>10)
      return a1
      a1+a2
    }
    //可以给参数指定默认值
    def play2(a1:Int=10)={
      //没有显示返回值不能return
    }
    def play3(a1:Int,a2:Int*)={
      var sum=a1
      for(i <- a2)sum+=i
      sum
    }
    def play4 = {
      println("hello")
    }
    //匿名函数
    val v1 = () => 10
    val v2 = (a:Int) => {
      println(a)
    }
    //这里是将匿名函数赋值给变量 返回的是function0 x个参数就返回functionx 最多能接受22个参数
    println(v1)
    println(v2)
    //通过变量传参执行
    println(v1())
    v2(111)
  }
}

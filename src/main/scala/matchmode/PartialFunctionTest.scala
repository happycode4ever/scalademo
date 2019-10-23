package matchmode

object PartialFunctionTest {
  def partialTest1: Unit ={
    def f2:PartialFunction[Any,Int]={
      case x:Int => x+1
    }

    val f:PartialFunction[Any,Int]={
      case x:Int => x+1
    }

    def f3:PartialFunction[Any,Any]={
      case x:Int => x+2
      case _ => "other"
    }
    val list = List(1,2,3,"4").collect(f3)
    println(list)

    //**定义的函数返回值是偏函数的话 可以直接写case返回的就是偏函数不需要写入参 但是返回偏函数的返回值类型表示输入输出的类型PartialFunction[input,ouput]
    def f4:PartialFunction[Any,Int]={
        case '+' => 1
        case '-' => -1
    }
    //偏函数主要包含两个方法isDefinedAt是指对于这个入参有没执行能力 apply是具体执行
    //**对于map来说不校验isDefinedAt 所以可能会报错 对于collect则先校验再执行
    println(f4.isDefinedAt('0'))
    println(f4.apply('+'))
    println(f4('+'))
  }

  def partialTest2: Unit ={
    val pf = new PartialFunction[(Any,Any),Int] {
      override def isDefinedAt(x: (Any, Any)): Boolean = {
        x._1.isInstanceOf[Int]&&x._2.isInstanceOf[Int]
      }

      override def apply(v1: (Any, Any)): Int = {
        val i1 = v1._1.asInstanceOf[Int]
        val i2 = v1._2.asInstanceOf[Int]
        i1*i2
      }
    }
//   if(pf.isDefinedAt("10",20))println(pf("10",20))
   if(pf.isDefinedAt(10,20))println(pf(10,20))
  }

  def main(args: Array[String]): Unit = {
//    partialTest1
    partialTest2
  }
}

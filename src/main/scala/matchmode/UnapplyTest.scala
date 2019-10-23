package matchmode

object UnapplyTest {

  object Square {
//    def unapply(arg: Double): Option[Double] = {
//      val result = Math.sqrt(arg)
//      println("Square unapply result:" + result)
//      //判断是否是整数
//      if (result % 1 == 0)
//        Some(result)
//      else
//        None
//    }

    def unapply(arg: Double): Option[(Any, Any)] = {
      val string = arg.toString
      val length = string.length
      if (length >= 6) {
        val n1 = string.substring(0, 2).toInt
        val n2 = string.substring(2, 4).toInt
        val n3 = string.substring(4, length).replace(".", "").toInt
        Some(Tuple2(n1,n2))
      } else
        None
    }
    def unapplySeq(arg: Double): Option[Seq[Int]] = {
      val string = arg.toString
      val length = string.length
      if (length >= 6) {
        val n1 = string.substring(0, 2).toInt*10
        val n2 = string.substring(2, 4).toInt*10
        val n3 = string.substring(4, length).replace(".", "").toInt*10
        Some(Array(n1, n2))
      } else
        None
    }
  }

  object Names {
    def unapplySeq(arg: Double): Option[Seq[Int]] = {
      val string = arg.toString
      val length = string.length
      if (length >= 6) {
        val n1 = string.substring(0, 2).toInt
        val n2 = string.substring(2, 4).toInt
        val n3 = string.substring(4, length).replace(".", "").toInt
        Some(Array(n1, n2, n3))
      } else
        None
    }
  }

  def f(x: Double): Double = {
    println("arg:" + x)
    x + 1
  }

  def main(args: Array[String]): Unit = {
    val d = 100000.0
    //    val result = f(d)
    //    println(result)
    d match {
      //注意case里 Object(n) 默认调用对象的unapply方法 但是类型必须保持一致 不然不会调用
        //如果没有unapply才会调用unapplySeq方法
        //只有unapply方法编译会校验接受结果的元组(n...)和返回值元素个数是否匹配 unapplySeq方法返回的是变长的系列则不校验
      case Square(n,n2) => println(s"match done! $d square result = $n $n2")
        //**注意一个对象里只能有一个unapply或者unapplySeq方法
      case Names(n1, n2, n3) => println(s"$n1 $n2 $n3")
      case _ => println("other")
    }
  }
}


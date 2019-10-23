package control

import scala.util.control.Breaks.{breakable, break}

object ForTest {
  def declareFor = {
    //<- 后面跟的是集合 1 to 10 等价于 Range(1,11,1) 默认步长是1
    for (i <- 1 to 10) {
      println(i)
    }
    println("-----------")
    for (i <- 1 to 3; j <- 2 to 4) {
      println("i=" + i, ",j=" + j)
    }
    println("-----------")
    //倒序输出，Range(start,end.step) 区间是[start,end)
    //**注意如果start<end没有结果
    for (i <- Range(-1, 5, 1)) {
      println(i)
    }
    println("-----------")
    //x util y [x,y) x to y [x,y]
    for (i <- 1 until 5) {
      println(i)
    }
    println("-----------")
    //守卫
    for (i <- 1 to 10 if i % 2 == 0) {
      println(i)
    }
    println("-----------")
    //引入变量
    for (i <- 1 to 5; j = 10 - i) {
      println(i + "," + j)
    }
    println("-----------")
    val ints = for (i <- 1 to 5) yield i
    println(ints) //返回的是Vetor集合
    println("-----------")
    //模拟continue功能需要Breaks的两个函数对于判断里break
    for (i <- 1 to 10) {
      breakable {
        if (i % 3 != 0) break else println(i)
      }
    }

  }

  def exerciseFor = {
    //打印5*4的实心矩形
    for (i <- 1 to 4; j <- 1 to 5) {
      print("* ")
      if (j == 5) println()
    }
    println("-----------")
    //打印1-100的素数
    //创建标记表示是素数
    var flag = true
    for (i <- 1 to 100) {
      if (i == 2) {
        println(i)
      }
      for (m <- 2 until i) {
        //遍历[2,i)如果存在该数能整除的就不是素数
        if (i % m == 0) {
          flag = false
        }
        //遍历完所有除数如果标记正确就输出，重置标记
        if (m == i - 1) {
          if (flag) println(i)
          flag = true
        }
      }
    }
    //遍历一个自然数集合，不取其中的奇数
    val ints = for (i <- 1 to 20 if i % 2 == 0 if i%4== 0) yield i
    println(ints)
    println("-----------------------")
    val res = for(i <- 1 to 20) yield {
        if(i%3==0)i
        else i+1
    }
    println(res)
  }

  def main(args: Array[String]): Unit = {
    //   declareFor
    exerciseFor
  }
}

package function

object ExceptionTest {
  def main(args: Array[String]): Unit = {
    def divide(a1:Int,a2:Int)={
      if(a2==0) throw new RuntimeException("除数是0")
      a1/a2
    }
    try {
      divide(10, 0)
    } catch {
      //match case匹配异常 多异常应该小到大排列
      case ex:RuntimeException => ex.printStackTrace()
    }
  }
}

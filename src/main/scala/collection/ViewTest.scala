package collection

object ViewTest {
  def main(args: Array[String]): Unit = {
//    val unit = (1 to 10000000).collect{case x if(x.toString.reverse==x.toString) => x}
    val viewSeq = (1 to 10000000).view.filter(x=>x.toString.reverse==x.toString)
    println(viewSeq.mkString("#"))
    //view是懒加载不缓存数据 使用的时候重新执行
    println(viewSeq.mkString("#"))

  }

}

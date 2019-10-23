package collection

object ParTest {
  def main(args: Array[String]): Unit = {
    //parRange遍历多线程执行
    (1 to 1000).par.foreach(x => {
      println(Thread.currentThread().getName+":"+x)
    })
    //parSeq多线程执行
//    List().par.foreach(println(_))
    //单线程执行只有主线程
    val distinctThreads = (0 to 1000).map({case _ => Thread.currentThread().getName}).distinct
    println(distinctThreads.getClass.getName)
    println(distinctThreads)
    //多线程执行默认用jdk8的ForkJoinPool
    val distinct2 = (0 to 1000).par.map({case _ => Thread.currentThread().getName}).distinct
    println(distinct2.getClass.getName)
    println(distinct2)

  }
}

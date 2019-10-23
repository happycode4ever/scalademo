package function

object ControlAbstractFuntionTest {
  //控制抽象 入参是无参函数 出参也是无参
  def runInThread(f: =>Unit):Unit={
    new Thread(new Runnable {
      override def run(): Unit = f
    }).start()
  }

  def main(args: Array[String]): Unit = {
    runInThread{
      println("start");Thread.sleep(3000);println("end")
    }
  }
}

package matchmode


object forMatchPropsTest {


  def main(args: Array[String]): Unit = {
    //**要转换位scala类型需要导包
    import scala.collection.JavaConverters._
    //ListBuffer(1,2,3,4).asJava//util.List
    val props = System.getProperties.asScala
    for ((k, v) <- props){
      println(k,v)
    }
    println("-----------------------")
    for((k,_)<-props){
      println(k)
    }
    println("-----------------------")
    //**剔除v是空的 scala字符串==直接比较值
    //方式1守卫
    for((k,v)<-props if v==""){
      println(k,v)
    }
    println("-----------------------")
    //方式2直接匹配空置
    for((k,"")<- props){
      println(k)
    }
  }
}

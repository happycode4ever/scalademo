package implicittest

object ImplicitClassTest{
  def main(args: Array[String]): Unit = {
    import StringExpand.StringUtil
    val res = "abcde".increment
    println(res)
  }
}
object StringExpand{
  //implicit class must have a primary constructor with exactly one argument in first parameter list
  //隐式类必须放在类/伴生类对象/包对象中
  //隐式类必须只有一个参数的主构造器
  implicit class StringUtil(x:String){
    //给入参类型的String添加方法
    //该方法实现了字符串中的每个字符ASCII码表+1的转换
    def increment = x.map(x=>(x+1).toChar)
  }
}


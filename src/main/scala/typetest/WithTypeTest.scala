package typetest

object WithTypeTest {
  def main(args: Array[String]): Unit = {
    //结构类型是指一组关于抽象方法、字段和类型的规格说明，你可以对任何具备play方法的类的实例调用play方法，这种方式比定义特质更加灵活，是通过反射进行调用的：
    //定义类型的结构体
    type X1 = {def play(msg:String):Unit}
    type X2 = {def add(x:Int,y:Int):Int}
    //混入多个类型
    type X = X1 with X2
    //定义方法接收混入的结构类型
    def init(x:X) = (arg1:Int,arg2:Int) => x.play((x.add(arg1,arg2)).toString)
    //调用该方法则必须包含定义的两个结构体内容
    init{new {
      def play(msg:String)= println(msg)
      def add(x:Int,y:Int)=x+y
    }}(10,20)
  }
}

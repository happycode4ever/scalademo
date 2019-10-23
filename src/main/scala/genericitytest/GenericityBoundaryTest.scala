package genericitytest

object GenericityBoundaryTest {
  def main(args: Array[String]): Unit = {
    new Pair1("aaa","a12")
//    new Pair1(11,15)
  }
}
//限定泛型T是jave的Comparable接口的子类型，这样就必须重写了compareTo方法
//**由于默认的Int类型没有实现Comparable接口 需要隐式转换成RichInt
class Pair1[T <% Comparable[T]](first:T,second:T){
  private val i: Int = first.compareTo(second)
  private val res = i match {
    case t if t<0 =>first
    case _ => second
  }
  println(s"first=$first,seconf=$second smaller is $res")
}

class Pair2[T](arg1:T,arg2:T){
  //<:相当于extends >:相当于super 定义的泛型必须放在左边 这个例子里不能写成 T <: R
  def replaceArg1[R >: T](newArg1:R) = new Pair2(newArg1,arg2)
}
//上下文界定 看不懂 留坑
class Pair4[T: Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]) = {
    println(ord)
    if (ord.compare(first, second) < 0) first else second
  }

  override def toString = "(" + first + "," + second + ")"
}
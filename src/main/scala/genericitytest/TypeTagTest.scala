package genericitytest

object TypeTagTest {
  //注意样例类不能继承
//  case class Animal()
//  case class Dog() extends Animal
  class Animal()
  class Dog() extends Animal

  //java向下兼容 所以会擦除泛型
  def match1(x:List[Any])= x match {
    case _:List[Int] => println("List[Int]")
    case _:List[String] => println("List[String]")
    case _:List[Any] => println("List[Any]")
    case _ => println("other")
  }
  //注意导包才能用TypeTag和TypeOf
  //TypeTag作用是将泛型类型存到一个集合里面 类型擦除后匹配时再拿出来
  import scala.reflect.runtime.universe._
  def match2[T:TypeTag](x:List[T])={
    typeOf[T] match {
      case t if t =:= typeOf[Int] => println("List[Int]")
      case t if t <:< typeOf[Animal] => println("List[Animal]")
      case t if t =:= typeOf[String] => println("List[String]")
      case t if t =:= typeOf[Any] => println("List[Any]")
    }
  }

  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List("1", "2", "3")
    val list3 = List("1", "2", 3)
    val list4 = List(new Dog,new Animal)


    match1(list1)
    match1(list2)
    match1(list3)
    println("-----------------------")
    match2(list1)
    match2(list2)
    match2(list3)
    match2(list4)
  }
}

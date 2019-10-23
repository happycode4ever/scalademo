package genericitytest

object MultiBoundaryTest {
  class Dog extends Animal
  class Cat
  class Fox
  class Animal

  class A
  class B
  //T <: A with B
  //T >: A with B
  //可以同时有上界和下界，如
  //T >: A <: B
//  可以同时有多个view bounds
//    T <% A <% B
//  这种情况要求必须同时存在 T=>A的隐式转换，和T=>B的隐式转换。 如果漏了任何一个就会编译报错
def foo[T >: Dog <: Animal](x:T)= println(x)

  def foo2[T <% A  <% B](x:T)=println(x)

  implicit def stringToA(x:String) = new A
  implicit def stringToB(x:String) = new B
  def main(args: Array[String]): Unit = {
    foo(new Animal)
    foo(new Dog)

    foo2("hello")
  }
}


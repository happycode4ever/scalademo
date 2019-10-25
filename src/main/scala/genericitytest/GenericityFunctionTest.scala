package genericitytest

object GenericityFunctionTest {
  def add[A,B](a:A,b:B) = a.toString + b.toString
}

package packagetest
package a {
  class A
  package b{
    class B
    package c{
      class C{
        private val a = new A
        private val b = new B
      }
    }
  }
}
package object a{
  val afield = "aaaaa"
}


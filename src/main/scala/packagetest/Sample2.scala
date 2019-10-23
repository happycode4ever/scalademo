package packagetest.a{
  package b.c{
    class D{
      //要使用父包的内容必须单独提取出需要使用的父包
      //如果使用如b.c的形式会略过b这个包的内容
      private val aclass = new A
      private val fieldFromA: String = afield
//      private val value = new B
    }
  }
}

package other{
  class Other{
    import packagetest.a
    private val afield: String = a.afield
  }
}
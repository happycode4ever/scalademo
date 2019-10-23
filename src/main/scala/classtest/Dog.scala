package classtest

package solar {
  package earth {

    import scala.beans.BeanProperty

    class Dog {

      //private[package/class] 设置访问权限 必须在同包下才有访问权限，如果设置this 那么属性只有this才有访问权限
      private[solar] var leg: Int = 4
      private[solar] var age: Int = 0
      @BeanProperty var own: String = null
//      private[this] var name: String = ""
      //private var name 等同于 private[Dog] var name
      private var name: String = ""

      def getInfo(dog: Dog): Unit = {
        //如果是 private[this] var name 会编译报错Symbol name is inaccessible from this place
        //需要改成private[Dog] 才可以使用
        //        println(dog.name)
        this.own = dog.own
        this.age = dog.age
        this.name = dog.name
      }
    }

  }

}


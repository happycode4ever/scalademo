package implicittest.expandclass



class Dog {
  val name = "金毛"
}

class Skill{
  //解耦技能对象，可以单独提取所有技能方法，但是目前Skill和Dog没关系，如果需要用到Dog的属性应该作为参数传入
  def fly(animal: Dog, skill: String) = println(animal.name + "已领悟" + skill)
}

object Learn{
  implicit def learningType(s : Dog) = new Skill
}


object ImplicitExpandClassTest {
  def main(args: Array[String]): Unit = {
    //讲隐式函数封装进伴生类对象中作为静态方法，通过导包的方式引入该隐式函数，就能将Dog转换为Skill拥有skill的方法
    //**注意点 导入的静态伴生对象如果是在同一个文件中的话，导包必须在该对象定义之后 否则会找不到
    import Learn.learningType

    val dog = new Dog
    dog.fly(new Dog,"飞")
  }
}
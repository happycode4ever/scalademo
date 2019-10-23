package classtest

object ConstructorTest {
  def main(args: Array[String]): Unit = {
    val my = new My("hello",11,"sz","boy","male","1993")
    my.name
//    my.name_=("hi")//val不生成set方法
//    my.name = "hey"//val也不支持重新赋值
    my.age
    my.age_=(20)
    my.age = 100
    println(my)
//    my.get(my)
//    my.addr//no symbol
//    my.info//no symbol
//    my.sex//inacessable
//    my.birth//inacessble
    val a = new AAA("hello",1111)
  }
}
class My(val name:String, var age:Int,addr:String,info:String,private val sex:String,private var birth:String){
//  override def toString = s"My($name, $age, $addr, $info, $sex, $birth)"
//
//  println(addr+info)

  def get(other:My): Unit ={
    val name = other.name
    val age = other.age
    other age_= 111
    this.addr
    //**注意不写val/var的方式 如果定义了方法使用到该变量会升级成员private[this] val 只能在本类本对象中使用
//    val addr = other.addr
//    val info = other.info
    val sex = other.sex
    other.birth = "2000"
    println(other)
  }
}
class AAA(name:String,age:Int){
  override def toString = s"AAA($age)"
}

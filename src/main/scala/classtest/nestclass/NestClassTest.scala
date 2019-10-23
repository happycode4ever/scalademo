package classtest.nestclass

import scala.collection.mutable.ArrayBuffer

object NestClassTest {
  def main(args: Array[String]): Unit = {
    val net1 = new Network
    val net2 = new Network
    val mary = net1.join("mary")
    val john = net1.join("john")
    val sunny = net1.join("sunny")
    val tom = net2.join("tom")
    mary.contacts += john
    mary.contacts += sunny
    john.contacts += mary
    john.contacts += sunny
    //如果contacts定义成ArrayBuffer[Member] network1的这个泛型实际类型相当于new Network().Member 每次new都不一样 无法添加到一块
    //解决方案1 讲这个member对象放到network的伴生类object中 那这个member类型就是静态的 相当于Network.Member
    //解决方案2 使用类型投影 ArrayBuffer[Network#Member] 不检查表明是Network的内部类Member即可
    println(mary.contacts)
    println(mary.contacts.hashCode())
    println(john.contacts)
    println(john.contacts.hashCode())
//    tom.contacts += mary

  }
}
class Network{
  val members = ArrayBuffer[Member]()
  class Member(name:String){
    //这个泛型类型实际是Network.this.Member
    // 所以不同network对象的内部类不能添加到一起
    val contacts = ArrayBuffer[Member]()
//    val contacts = new ArrayBuffer[Network#Member]()
  }
  def join(name:String) = {
    val m = new Member(name)
    members += m
    m
  }

}

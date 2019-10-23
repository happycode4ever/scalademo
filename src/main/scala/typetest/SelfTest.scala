package typetest

object SelfTest {

}
class A {
  self =>  //this别名 可以随便取 必须放在第一行
  val x=2
  def foo = self.x + this.x
}
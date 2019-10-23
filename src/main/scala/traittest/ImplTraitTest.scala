package traittest.impltrait

object ImplTraitTest {
  def main(args: Array[String]): Unit = {
    new Account().withDraw(100)
  }
}
trait logger{
  def log(msg:String)= println(msg)
}
class Balance{
  protected var balance = 0.0
}
class Account extends Balance with logger{
  def withDraw(amount:Double): Unit ={
    if(balance < amount)log("余额不足")
    else balance -= amount
  }
}

package classtest

class Animal(var age:Int) {
  val school:String = "蓝翔"
    private[classtest] var name:String=_
    def this(name:String,age:Int){
      this(age)
      this.name = name
    }
//  def this(name:String){
  ////    this(name,0)
  ////  }

}
package classtest

import classtest.solar.earth.Dog
package solar {

  object DogTest {
    def main(args: Array[String]): Unit = {
      val dog = new Dog
      dog.own_=("10")
      dog.leg = 4
      println(dog.own)
      println(dog.leg)
      val dog2 = new Dog
      dog2.getInfo(dog)
      println(dog2.own+","+dog2.leg)
    }

  }

}

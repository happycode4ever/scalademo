package annotationtest

import scala.util.control.TailCalls._


object TailCallTest {
  def evenLength(xs: Seq[Int]): TailRec[Boolean] = {
    if(xs.isEmpty) done(true) else tailcall(oddLength(xs.tail))
  }

  def oddLength(xs: Seq[Int]): TailRec[Boolean] = {
    if(xs.isEmpty) done(false) else tailcall(evenLength(xs.tail))
  }


def main(args: Array[String]): Unit = {
  val res = evenLength(1 to 3).result
  println(res)
  }
}

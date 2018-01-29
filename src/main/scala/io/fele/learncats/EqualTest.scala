package io.fele.learncats

import cats._
import cats.implicits._

object EqualTest extends App {
  val intOpt1: Option[Int] = Some(1)
  val intOpt2: Option[Int] = Some(1)
  val i = 2

  val eqInt = Eq[Int]
  println(intOpt1 === intOpt2)


//  println(eqInt.eqv(intOpt,i))
}

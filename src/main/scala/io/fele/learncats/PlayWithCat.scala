package io.fele.learncats

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.instances.option._
import cats.syntax.eq._
import cats.Eq

object PlayWithCat extends App {
  implicit val eqCat: Eq[Cat] = Eq.instance[Cat]((lhs, rhs) => {
    lhs.name === rhs.name &&
      lhs.age === rhs.age &&
      lhs.color === rhs.color
  })

  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  println(optionCat1 ===  optionCat2)
  println(optionCat1 =!=  optionCat2)
}

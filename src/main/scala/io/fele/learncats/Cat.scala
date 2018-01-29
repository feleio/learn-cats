package io.fele.learncats

import cats._
import cats.implicits._


final case class Cat(name: String, age: Int, color: String)

object Cat extends App {
  implicit val printCat: Show[Cat] = Show.show[Cat](c => s"${c.name} is a ${c.age} years old ${c.color} cat")

  val doraemon = Cat("Doraemon", 100, "blue")

  println(doraemon.show)
}
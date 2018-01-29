package io.fele.learncats

import cats.Traverse
import cats.data.Writer
import cats.instances.string._



case class Remember[L, A](messages: List[L], v: A)

object Remember extends App {
  val a = implicitly[Monad[Writer[String, String]]]
  println(a)

  Writer[String, String]("a", "b").flatMap
//  implicit def rememberMonoid = new Monad[Remember] {
//    override def pure[A](a: A) = Remember(Nil, a)
//
//    override def flatMap[A, B](value: Remember[A])(func: A => Remember[B]) =
//      Remember(func(value).messages ++ value.messages.map(a => ))
//
//    override def map[A, B](value: Remember[A])(func: A => B) =
//      Remember(value :: func(value))
//  }
}
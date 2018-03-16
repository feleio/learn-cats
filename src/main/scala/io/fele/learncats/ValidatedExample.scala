package io.fele.learncats

import cats.data.ValidatedNel

import cats.syntax.validated._
import cats.syntax.apply._
import cats.instances.option._

case class MyException(errorMsg: String) extends Exception

object ValidatedExample extends App {
  type ValidatedResult[A] = ValidatedNel[MyException, A]

  val step1: ValidatedResult[String] = MyException("error 1").invalidNel
  val step2: ValidatedResult[String] = "good!".validNel
  val step3: ValidatedResult[String] = MyException("error 2").invalidNel

  case class Threesome(a: String, b: String, c: String)
  case class Twosome(a: String, b: String)

  (step1, step2, step3).mapN(Threesome)
//  (step1 |@| step2 |@| step3).map(Threesome)

  val opt1: Option[Int] = Some(0)
  val opt2: Option[Int] = None
  val opt3: Option[Int] = None

  (opt1, opt2, opt3).mapN(_ + _ + _)

  val a1:ValidatedNel[MyException, String] =  MyException("error 1").invalidNel
  val a2:ValidatedNel[MyException, String] =  MyException("error 1").invalidNel

}

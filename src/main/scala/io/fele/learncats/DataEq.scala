package io.fele.learncats

import java.util.Date
import cats.Eq
import cats.instances.long._
import cats.syntax.eq._


object DataEq extends App {
  implicit val dateEq: Eq[Date] =
    Eq.instance[Date] { (date1, date2) =>
      date1.getTime === date2.getTime
    }

  val a = new Date()
  Thread.sleep(1)
  val b = new Date()

  println(a === b)
}

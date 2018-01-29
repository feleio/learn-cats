package io.fele.learncats

trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit ev: Printable[A]): String =
    ev.format(value)

  def print[A](value: A)(implicit ev: Printable[A]): Unit =
    println(format(value))
}
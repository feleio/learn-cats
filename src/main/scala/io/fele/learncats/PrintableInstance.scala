package io.fele.learncats

object PrintableInstance {
  implicit val stringPrint = new Printable[String] {
    override def format(a: String) = a
  }

  implicit val intPrint = new Printable[Int] {
    override def format(a: Int) = a.toString
  }
}

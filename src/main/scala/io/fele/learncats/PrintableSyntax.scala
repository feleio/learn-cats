package io.fele.learncats

object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit ev: Printable[A]): String = ev.format(a)

    def print(implicit ev: Printable[A]): Unit = println(ev.format(a))
  }
}

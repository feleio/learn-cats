package io.fele.learncats

import cats.Eval

object EvalExample extends App {
  val res = for {
    a <- Eval.now { println("cal a"); 40 }
    b <- Eval.now { println("cal b"); 2 }
  } yield {
    println("adding a and b")
    a + b
  }

  println("!!"+res.value)
  println("!!"+res.value)
}

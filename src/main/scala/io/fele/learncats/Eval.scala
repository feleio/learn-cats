package io.fele.learncats

import cats.Eval

object EvalApp extends App {
  def foldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = as match {
    case head :: tail =>
      fn(head, foldRight(tail, acc)(fn))
    case Nil =>
      acc
  }

  def foldRightEval[A, B](as: List[A], acc: B)(fn: (A, B) => B): Eval[B] = as match {
    case head :: tail =>
      Eval.defer(foldRightEval(tail, acc)(fn).map(fn(head, _)))
    case Nil =>
      Eval.now(acc)

  }

  val l: List[Int] = List(1,2,3,4,5)

//  val sum = foldRight((1 to 100000).toList, 0L)(_ + _)
//  println(sum)



  val sumEval = foldRightEval((1 to 100000).toList, 0L)(_ + _)
  println(sumEval.value)



}

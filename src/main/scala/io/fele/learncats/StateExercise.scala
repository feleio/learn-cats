package io.fele.learncats

import cats.data.State

import scala.util.Try

object StateExercise extends App {
  type CalcState[A] = State[List[Int], A]

  val p = """([\d+\-*/]) (.+)""".r

  def evalOne(sym: String): CalcState[Int] = {
    sym match {
      case i if Try(i.toInt).isSuccess => State(s => (i.toInt :: s, i.toInt))
      case "+" => State(s => (s.head + s.tail.head :: s.tail.tail, s.head + s.tail.head))
      case "-" => State(s => (s.head - s.tail.head :: s.tail.tail, s.head - s.tail.head))
      case "*" => State(s => (s.head * s.tail.head :: s.tail.tail, s.head * s.tail.head))
      case "/" => State(s => (s.head / s.tail.head :: s.tail.tail, s.head / s.tail.head))
    }
  }

  def interpreter(s: String): CalcState[Int] = s match {
    case p(head, tail) =>
      evalOne(head).flatMap(_ => interpreter(tail))
    case _ => evalOne(s)
  }

  val input = "1 2 + 3 *"
  println(interpreter(input).runA(Nil).value)
}

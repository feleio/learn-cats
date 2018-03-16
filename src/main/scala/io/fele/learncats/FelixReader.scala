package io.fele.learncats

import scala.language.higherKinds
import cats.Monad
import cats.syntax.monad._

//case class FelixReader[A, B](f: A => B) {
//  def run(a: A): B = f(a)
//  def map[C](g: B => C): FelixReader[A, C] = FelixReader(x => g(run(x)))
//  def flatMap[C](g: B => FelixReader[A, C]): FelixReader[A, C] =
//    FelixReader((x: A) => g(run(x)).f(x))
//}

//trait FelixReaderMonad[A] {
//  type FelixReader0[B] = FelixReader[A, B]
//  implicit val felixReaderInstance = new Monad[FelixReader0] {
//    override def pure[B](a: B): FelixReader0[B] = FelixReader(_ => a)
//
//    override def flatMap[B, C](value: FelixReader0[B])(func: B => FelixReader0[C]) =
//      value.flatMap(func)
//
//    override def map[B, C](value: FelixReader[A, B])(func: B => C) = value.map(func)
//  }
//}

//object FelixReader {
//  implicit def felixReaderInstance[A] = {
//    type FelixReader0[B] = FelixReader[A, B]
//    new Monad[FelixReader0] {
//      override def pure[B] (a: B): FelixReader0[B] = FelixReader (_ => a)
//
//      override def flatMap[B, C] (value: FelixReader0[B] ) (func: B => FelixReader0[C] ) =
//      value.flatMap (func)
//
//      override def map[B, C] (value: FelixReader[A, B] ) (func: B => C) = value.map (func)
//    }
//  }
//}
//
//case class Cat(name: String, age: Int)
//
//object felixReaderApp extends App {
//  def runReader[T](m1: T)(m2: T)(implicit ev: Monad[T]) = {
//    println(
//      for {
//        b1 <- m1
//        b2 <- m2
//      } yield (b1, b2)
//    )
//  }
//
//  val greetCat = FelixReader((c: Cat) => s"hi ${c.name}")
//  val ageCat = FelixReader((c: Cat) => s"you age is ${c.age}")
//
//  runReader(greetCat)(ageCat)
//}
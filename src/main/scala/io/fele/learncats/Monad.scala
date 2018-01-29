package io.fele.learncats

import scala.language.higherKinds

trait Monad[F[_]] {
  def pure[A](a: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A, B](value: F[A])(func: A => B): F[B]
}

import cats.Id

object Monad {
  implicit val idMonad = new Monad[Id] {
    def pure[A](a: A): Id[A] = a

    def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = func(value)

    def map[A, B](value: Id[A])(func: A => B): Id[B] = func(value)
  }
}
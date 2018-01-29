package io.fele.learncats

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit val booleanAndMonoid = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean) = x && y
    override def empty = true
  }

  implicit val booleanOrMonoid = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean) = x || y
    override def empty = false
  }

  implicit def setMonoid[A] = new Monoid[Set[A]]{
    override def combine(x: Set[A], y: Set[A]) = x ++ y

    override def empty = Set.empty[A]
  }
}

object app extends App {
  def combineTwo[T](a: T, b: T)(implicit ev: Monoid[T]): T = ev.combine(a, b)

  println(combineTwo(Set(1,2,3), Set(4,5,6)))
  println(combineTwo(Set(true), Set(false)))
}
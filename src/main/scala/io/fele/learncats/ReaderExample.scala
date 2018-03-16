package io.fele.learncats

import cats.data.Reader
import cats.syntax.applicative._

case class Db(
  usernames: Map[Int, String],
  passwords: Map[String, String]
)

object ReaderExample extends App {
  type DbReader[T] = Reader[Db, T]

  def findUserName(userId: Int): DbReader[Option[String]] = Reader { db: Db =>
    db.usernames.get(userId)
  }

  def checkPassword(username: String, password: String): DbReader[Boolean] = Reader { db: Db =>
    db.passwords.get(username).contains(password)
  }

  def checkLogin(userId: Int, password: String): DbReader[Boolean] = for {
    userNameOpt <- findUserName(userId)
    loginOk <- userNameOpt.map(userName => checkPassword(userName, password)).getOrElse(false.pure[DbReader])
  } yield loginOk

  val users = Map(
    1 -> "dade",
    2 -> "kate",
    3 -> "margo"
  )
  val passwords = Map(
    "dade"  -> "zerocool",
    "kate"  -> "acidburn",
    "margo" -> "secret"
  )

  val db = Db(users, passwords)

  println(checkLogin(4, "davinci").run(db))
}

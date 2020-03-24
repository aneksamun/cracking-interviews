import cats.{Id, Monad}
import cats.implicits._

object IdMonad {

  def echoConcat[F[_] : Monad](s1: F[String], s2: F[String]): F[String] = {
    for {
      x <- s1
      y <- s2
    } yield s"echo $x $y"
  }

  echoConcat(Option("one"), Option("two")).foreach(println)

  println(echoConcat("three": Id[String], "four": Id[String]))

  println(echoConcat[Id]("five", "six"))
}

package u02

object Compose extends App :

  def genericCompose [A] (f: A => A, g: A => A): (A => A) = f compose g
  println(genericCompose[String](_ + " Uno", _ + " Due")("Tre"))
  println(genericCompose[Int](_ - 1, _ * 2)(5))

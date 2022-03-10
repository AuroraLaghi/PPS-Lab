package u02

object Es2 extends App:

  val neg: (String => Boolean) => String => Boolean = f => !f(_)
  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)
  println(notEmpty("foo")) //true
  println(notEmpty("")) //false
  println(notEmpty("foo") && !notEmpty("")) //true

  def negMethod(f: String => Boolean): String => Boolean  = !f(_)
  val notEmptyMethod = negMethod(empty)
  println(notEmptyMethod("foo")) //true
  println(notEmptyMethod("foo") && !notEmptyMethod("")) //true

  def negGeneric[A](f: A => Boolean): A => Boolean = !f(_)
  def negEmptyGeneric[A]: (A => Boolean) = _ == ""
  val notEmptyGeneric = negGeneric(negEmptyGeneric)
  println(notEmptyGeneric(5)) //true
  println(notEmptyGeneric("")) //false
  println(notEmptyGeneric("foo") && !notEmptyGeneric("")) //true




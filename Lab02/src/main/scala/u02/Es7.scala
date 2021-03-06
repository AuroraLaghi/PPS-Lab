package u02

object Es7 extends App : // questo si fa perchè estende un'applicazione eseguibile

  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(pred: A => Boolean): Option[A] = opt match
      case Some(a) if pred(a) => opt
      case _ => None()

    def map[A, O](opt: Option[A])(pred: A => /*Boolean*/O): Option[/*Boolean*/O] = opt match
      /*case Some(a) if !pred(a) => Some(false)*/
      case Some(a) => Some(pred(a))
      case _ => None()

    def map2[A,B](opt1: Option[A])(opt2: Option[B]): Option[(A,B)] = (opt1, opt2) match
      case (Some(a), Some(b)) => Some(a,b)
      case _ => None()

  import Option.*

  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = None()

  println(s1) // Some(1)
  println(orElse(s1, 0))
  println(orElse(s3, 0)) // 1,0
  println(flatMap(s1)(i => Some(i + 1))) // Some(2)
  println(flatMap(s1)(i => flatMap(s2)(j => Some(i + j)))) // Some(3)
  println(flatMap(s1)(i => flatMap(s3)(j => Some(i + j)))) // None

  println(filter(Some(5))(_>2)) // Some(5)
  println(filter(Some(5))(_>8)) // None
  println(filter(None[Int]())(_>2)) // None

  println(map(s1)(_>2)) // Some(false)
  println(map(Some(5))(_>2)) // Some(true)
  println(map(Some(5))(_>8)) // Some(false)
  println(map(s3)(_>(-1))) // None
  println(map(None[Int]())(_>2)) // None

  println(map2(s1)(s2)) // Some((1,2))
  println(map2(Some(20))(Some(30))) // Some((20,30))
  println(map2(s1)(s3)) // None
package u03

import u02.Modules.Person

import java.util.concurrent.locks.Condition
import scala.annotation.tailrec
import u02.Optionals.Option.*
import u02.Optionals.*
import u02.Modules.Person.*
import u02.Modules.Person.Teacher

object Lists extends App:

  // A generic linkedlist
  enum List[E]:
    case Cons(head: E, tail: List[E])
    case Nil()
  // a companion object (i.e., module) for List
  object List:

    def sum(l: List[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _ => 0

    def map[A, B](l: List[A])(mapper: A => B): List[B] = l match
      case Cons(h, t) => Cons(mapper(h), map(t)(mapper))
      case Nil() => Nil()

    def filter[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match
      case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
      case Cons(_, t) => filter(t)(pred)
      case Nil() => Nil()

    def drop[A](l: List[A], n: Int): List[A] = l match
      case Cons(h, t) if (n > 0) => drop(t,n-1)
      case Cons(h, t) if (n == 0) => l
      case Nil() => Nil()

    def append[A](l1: List[A], l2: List[A]): List[A] = (l1,l2) match
      case (Cons(h, t), right) => Cons(h, append(t, l2))
      case _ => l2

    def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match
      case Cons(h, t) => append(f(h), flatMap(t)(f))
      case Nil() => Nil()

    def mapFlatMap[A,B](l: List[A])(mapper: A => B): List[B] = l match
      case Cons(h, t) => flatMap(l)(c => Cons(mapper(c),Nil()))
      case Nil() => Nil()

    def filterFlatMap[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match
      case Cons(h, t) => flatMap(l1)(c => if(pred(c)) Cons(c, Nil()) else Nil())
      case Nil() => Nil()

    def max(l: List[Int]): Option[Int] =
      @annotation.tailrec
      def _max(l1: List[Int], temp: Option[Int]): Option[Int] = l1 match
        case Cons(h, t) if isEmpty(temp) || h > orElse(temp,0) => _max(t, Some(h))
        case Cons(h, t) => _max(t,temp)
        case Nil() => temp

      _max(l,None())

    def teacherCourses(l: List[Person]): List[String] =
      flatMap(filter(l)(c => c.isInstanceOf[Teacher]))(c => Cons(c.asInstanceOf[Teacher].course, Nil()))

    def foldLeft[A,B](l: List[A])(x: B)(f: (B, A) => B): B = l  match
      case Cons(h, t) =>
        val a = f(x,h)
        foldLeft(t)(a)(f)
      case _ => x

    def foldRight[A,B](l: List[A])(x: B)(f: (A, B) => B): B = l match
      case Cons(h, t) => f(h, foldRight(t)(x)(f))
      case _ => x

  val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
  println(List.sum(l)) // 60

  import List.*

  println(sum(map(filter(l)(_ >= 20))(_ + 1))) // 21+31 = 52




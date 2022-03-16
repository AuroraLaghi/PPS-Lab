package u03

import org.junit.*
import org.junit.Assert.*
import Lists.*
import u02.Optionals.Option.*
import u02.Optionals.*

class ListTest:
  import List.*

  val l: List[Int] = Cons(10, Cons(20, Cons(30, Nil())))
  val tail1 = Cons(40, Nil())
  val tail2 = Cons(5, Nil())
  val list: List[Int] = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))

  @Test def testSum() =
    assertEquals(0, sum(Nil()))
    assertEquals(60, sum(l))

  @Test def testMap() =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), map(l)(_ + 1))
    assertEquals(Cons("10", Cons("20", Cons("30", Nil()))), map(l)(_ + ""))

  @Test def testFilter() =
    assertEquals(Cons(20, Cons(30, Nil())), filter(l)(_ >= 20))
    assertEquals(Cons(10, Cons(30, Nil())), filter(l)(_ != 20))

  @Test def testDrop() =
    assertEquals(Cons(20, Cons(30, Nil())), drop(l, 1))
    assertEquals(Cons(30, Nil()), drop(l, 2))
    assertEquals(Nil(), drop(l, 4))

  @Test def testAppend() =
    assertEquals(Cons(10, Cons(20, Cons(30, Cons(40, Nil())))), append(l, tail1))
    assertEquals(append(tail2, l), Cons(5, Cons(10, Cons(20, Cons(30, Nil())))))

  @Test def testFlatMap() =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))),flatMap(l)(v => Cons(v + 1, Nil())))
    assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))),flatMap(l)(v => Cons(v + 1, Cons(v +2,  Nil()))))

  @Test def testMapFlatMap() =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), mapFlatMap(l)(_ + 1))
    assertEquals(Cons("10", Cons("20", Cons("30", Nil()))), mapFlatMap(l)(_ + ""))

  @Test def testFilterFlatMap() =
    assertEquals(Cons(20, Cons(30, Nil())), filterFlatMap(l)(_ >= 20))
    assertEquals(Cons(10, Cons(30, Nil())), filterFlatMap(l)(_ != 20))
    assertEquals(Cons(10, Cons(20, Nil())), filterFlatMap(l)(_ < 30))

  @Test def testMax() =
    assertEquals(Some(25), max(Cons(10, Cons(25, Cons(20, Nil())))))
    assertEquals(None(), max(Nil()))

  @Test def testFold() =
    assertEquals(-16, foldLeft(list)(0)(_-_))
    assertEquals(-8, foldRight(list)(0)(_-_))


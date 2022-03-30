package u05lab.ex1

import org.junit.Test
import org.junit.Assert.*
import List.*

class ListTest {

  val list: List[Int] = List(1, 2, 3, 4)
  var list1: List[Int] = List(10)

  /** todo */
  @Test
  def testZipRight(): Unit =
    assertEquals(List((1, 0), (2, 1), (3, 2), (4, 3)), list.zipRight1)
    assertEquals(List((1, 0), (2, 1), (3, 2), (4, 3)), list.zipRight2)

  @Test
  def testPartition(): Unit =
    assertEquals((List(2, 4), List(1, 3)), list.partition1(_ % 2 == 0))
    assertEquals((List(2, 4), List(1, 3)), list.partition2(_ % 2 == 0))

  @Test
  def testSpan(): Unit =
    assertEquals((List(1), List(2, 3, 4)), list.span(_ % 2 != 0))
    assertEquals((List(1, 2), List(3, 4)),list.span(_ < 3))

  @Test
  def testReduce(): Unit =
    assertEquals(10,list.reduce(_ + _))
    assertEquals(10,list.reduce(_ + _))

  @Test
  def testTakeRight(): Unit =
    assertEquals(List(2, 3, 4), list.takeRight(3))

}

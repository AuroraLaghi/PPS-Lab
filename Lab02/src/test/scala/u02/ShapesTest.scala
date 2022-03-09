package u02

import org.junit.*
import org.junit.Assert.*
import u02.Shapes.Figure.*

class ShapesTest :

  val rectangle = Rectangle(5,2)
  val circle = Circle(0)
  val square = Square(6)

  @Test def testPerimeter() =
    assertEquals(14,perimeter(rectangle),0)
    assertEquals(0,perimeter(circle),0)
    assertEquals(24,perimeter(square),0)

  @Test def testArea() =
    assertEquals(10,area(rectangle),0)
    assertEquals(0,area(circle),0)
    assertEquals(36,area(square),0)
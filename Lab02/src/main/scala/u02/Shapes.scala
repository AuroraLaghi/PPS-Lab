package u02

object Shapes extends App :
  enum Figure:
    case Rectangle(base: Double, height: Double)
    case Circle(radius: Double)
    case Square(base: Double)

  object Figure:
    def perimeter(f: Figure): Double = f match
      case Rectangle(base,height) => base*2+height*2
      case Circle(radius) => 2*Math.PI*radius
      case Square(base) => base*4
    def area(f: Figure): Double = f match
      case Rectangle(base,height) => base*height
      case Circle(radius) => Math.PI*radius*radius
      case Square(base) => base*base

  println(Figure.perimeter(Figure.Rectangle(5,2)))
  println(Figure.perimeter(Figure.Circle(4)))
  println(Figure.perimeter(Figure.Square(6)))
  println(Figure.area(Figure.Rectangle(5,2)))
  println(Figure.area(Figure.Circle(4)))
  println(Figure.area(Figure.Square(6)))






package u02

object Es5 extends App:
  def fibonacci(n: Int): Int = n match
    case n if n < 0 => -1
    case n if n == 0 => 0
    case n if n == 1 => 1
    case n if n == 2 => 1
    case _ => fibonacci(n-1) + fibonacci(n-2)
  println(fibonacci(10)) // 55
  println(fibonacci(-10)) // -1

  def fib(n: Int): Int =
    def fibonacciTail(n: Int, prev: Int, current: Int): Int = n match
      case 0 => prev
      case _ => fibonacciTail(n-1, current, prev+current)
    return fibonacciTail(n,0,1)
  println(fib(10)) // 55






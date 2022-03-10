package u02

object Es1 extends App:

  val parity1: Int => String = _ match
    case x if(x % 2) == 0 => "even"
    case _ => "odd"

  def parity2(x: Int): String = x match
    case x if(x % 2) == 0 => "even"
    case _ => "odd"
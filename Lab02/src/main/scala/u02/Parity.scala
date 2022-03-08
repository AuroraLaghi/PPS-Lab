package u02

object Parity extends App:

  val parity1: Int => String = _ match
    case x if(x%2)==0 => "even"
    case _ => "odd"

  println(parity1(50));
  println(parity1(35));

  def parity2(x:Int): String = x match
    case x if(x%2)==0 => "even"
    case _ => "odd"

  println(parity1(1));
  println(parity1(20));


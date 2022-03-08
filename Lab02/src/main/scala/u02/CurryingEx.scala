package u02

object CurryingEx extends App :
  def noCurryingDef(x: Double, y: Double, z: Double): Boolean = x<=y && y<=z
  println(noCurryingDef(1,1,10)) //true
  def curryingDef(x: Double)(y: Double)(z:Double): Boolean = x<=y && y<=z
  println(curryingDef(8)(7)(10)) //false
  val curryingVal: Double => Double => Double => Boolean = x => y => z => x<=y && y<=z
  println(curryingVal(1)(2)(2)) //true
  val noCurryingVal = (x:Double, y:Double, z:Double) => (x<=y && y>=z)
  println(noCurryingVal(2,1,10)) //false





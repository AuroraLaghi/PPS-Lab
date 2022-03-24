package u04lab.polyglot.a05b


import u04lab.polyglot.Pair

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:

  private var _tickCount = 0
  private final var _gridSize = size
  val random = Random()
  var initial = (random.nextInt(_gridSize-2) + 1, random.nextInt(_gridSize-2)+1)

  override def tick(): Unit = {
    this._tickCount = this._tickCount+1
  }

  override def isOver: Boolean =
    initial._2 - _tickCount < 0 || initial._2 + _tickCount >= this._gridSize ||
    initial._1 - _tickCount < 0 || initial._1 + _tickCount >= this._gridSize


  override def hasElement(x: Int, y: Int): Boolean =
    (x == initial._1 && Math.abs(y - initial._2) <= _tickCount) ||
    (y == initial._2 && Math.abs(x - initial._1) <= _tickCount) ||
    (x-y == initial._1 - initial._2 && Math.abs(x - initial._1) <= _tickCount) ||
    (x+y == initial._1 + initial._2 && Math.abs(x - initial._1) <= _tickCount)

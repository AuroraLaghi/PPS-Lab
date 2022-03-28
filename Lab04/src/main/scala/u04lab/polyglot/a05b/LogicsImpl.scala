package u04lab.polyglot.a05b


import u04lab.polyglot.Pair

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:

  private var _tickCount = 0
  private final var _gridSize = size
  private val random = Random()
  private var _initial = (random.nextInt(_gridSize-2) + 1, random.nextInt(_gridSize-2)+1)

  override def tick(): Unit =
    this._tickCount = this._tickCount+1

  override def isOver: Boolean =
    _initial._2 - _tickCount < 0 || _initial._2 + _tickCount >= this._gridSize ||
    _initial._1 - _tickCount < 0 || _initial._1 + _tickCount >= this._gridSize


  override def hasElement(x: Int, y: Int): Boolean =
    (x == _initial._1 && Math.abs(y - _initial._2) <= _tickCount) ||
    (y == _initial._2 && Math.abs(x - _initial._1) <= _tickCount) ||
    (x-y == _initial._1 - _initial._2 && Math.abs(x - _initial._1) <= _tickCount) ||
    (x+y == _initial._1 + _initial._2 && Math.abs(x - _initial._1) <= _tickCount)

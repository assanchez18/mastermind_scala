package models

class Combination(roundValue: List[Int] = List(-1, -1, -1, -1), value: Int = 0 ) {

  private val value_ = value
  protected val row_ = roundValue

  def roundNumber: Int = value_
  def row: List[Int] = row_

  def getColor(position: Int):Int = row_(position)

  def isEmpty():Boolean = row_(0) == -1

  def getRoundNumber():String = value_.toString
}
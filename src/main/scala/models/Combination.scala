package models

class Combination(roundValue: List[Int] = List(-1, -1, -1, -1), value: Int = 0 ) {

  private val value_ = value
  protected val row_ = roundValue

  def roundNumber: Int = value_
  def row: List[Int] = row_

  def getColor(position: Int):Int = row_(position)

  def isEmpty():Boolean = row_(0) == -1

  def getRoundNumber():String = value_.toString

  def checkResult(secret: List[Int]):((Char,Int),(Char,Int)) = {
    def countDead(row:List[Int],secret:List[Int], dead:Int):(Char,Int) = {
      secret match {
        case Nil => ('B',dead)
        case head :: tail if (head == row.head) => countDead(row.tail, tail, dead+1)
        case _ :: tail => countDead(row.tail, tail, dead)
      }
    }
    def countInjured(row:List[Int],secret:List[Int], injure:Int):(Char,Int) = {
      secret match {
        case Nil => ('W',injure)
        //case head :: tail
        case _ =>('W',injure)
      }

    }

    (countDead(this.row_,secret,0),countInjured(this.row_,secret,0))
  }
}
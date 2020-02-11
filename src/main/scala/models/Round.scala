package models

class Round(roundValue: List[Int] = List(-1, -1, -1, -1), value: Int = 0 ) {

  /*def this(rowNumber:Int) = this(List(-1,-1,-1,-1), rowNumber)
  def this(roundValue: List[Int],rowNumber:Int) = this(roundValue ,rowNumber)
*/
  private val value_ = value
  private val row_ = roundValue

  def roundNumber: Int = value_
  def row: List[Int] = row_

 /* override def equals(that: Any): Boolean =
    that match {
      case that: Round =>
        this.value_ == that.value_ && row_
      case _ => false
    }
*/
  def getColor(position: Int):Int = row_(position)
}
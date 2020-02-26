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
    def checkResultAux(row:List[Int],secret:List[Int]):((Char,Int),(Char,Int)) = {

      def checkResultAux2(row:List[Int],secret:List[Int], dead:Int, remainingRow:List[Int], remainingSec:List[Int]):((Char,Int),(Char,Int)) = {

        def countInjured(row:List[Int],secret:List[Int], injure:Int):(Char,Int) = {
          //todo injured logic
          secret match {
            case Nil => ('W',injure)
            case head :: tail => if(tail.)

            //case head :: tail
            case _ =>('W',injure)
          }
        }

        row match {
          case Nil => (('B',dead), countInjured(remainingRow, remainingSec,0))
            //acumulates dead but lists keep as them were, pseudo popping item
          case head :: tail if (head == secret.head) => checkResultAux2(tail, secret.tail, dead+1, remainingRow, remainingSec)
            //not match, then we add those two values to the remaining list, we will find whites later
          case _ :: tail => checkResultAux2(secret.tail, tail, dead, remainingRow :: row.head, remainingSec :: secret.head)
        }
      }
      checkResultAux2(this.row_,secret,0,Nil,Nil)
    }
    checkResultAux(this.row_,secret)
  }
}
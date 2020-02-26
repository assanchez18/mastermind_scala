package models

class Combination(roundValue: List[Int] = List(-1, -1, -1, -1), value: Int = 0 ) {

  private val value_ = value
  private val row_ = roundValue

  def roundNumber: Int = value_
  def row: List[Int] = row_

  def getColor(position: Int):Int = row_(position)

  def isEmpty():Boolean = row_(0) == -1

  def getRoundNumber():String = value_.toString

  def checkResult(secret: List[Int]):((Char,Int),(Char,Int)) = {
    def checkResultAux(row:List[Int],secret:List[Int]):((Char,Int),(Char,Int)) = {

      def checkResultAux2(row:List[Int],secret:List[Int], dead:Int, remainingRow:List[Int], remainingSec:List[Int]):((Char,Int),(Char,Int)) = {

        def countInjured(row:List[Int],secret:List[Int], injure:Int):(Char,Int) =
          row match {
            case Nil => ('W',injure)
            case head :: tail if(secret.contains(head)) => countInjured(tail,secret.patch(secret.indexOf(head),Seq(-1),1), injure+1)
            case _ :: tail => countInjured(tail, secret, injure)
          }

        row match {
          case Nil => (('B',dead), countInjured(remainingRow, remainingSec,0))
          case head :: tail if (head == secret.head) => checkResultAux2(tail, secret.tail, dead+1, remainingRow, remainingSec)
          case _ :: tail => checkResultAux2(tail, secret.tail, dead, remainingRow.appended(row.head), remainingSec.appended(secret.head))
        }
      }
      checkResultAux2(this.row_,secret,0,Nil,Nil)
    }
    checkResultAux(this.row_,secret)
  }

  def isMastermind(): Boolean = checkResult(SecretCombination.getSecretCombination())._1._2 == 4
  def isMastermind(sec: List[Int]): Boolean = checkResult(sec)._1._2 == 4
}
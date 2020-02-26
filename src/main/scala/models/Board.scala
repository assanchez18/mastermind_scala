package models

class Board(rows: List[List[Int]] = List(
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1),
  List(-1,-1,-1,-1)
)) {

  private val rows_ = rows


  def getColor(roundNumber:Int): Int = rows_(roundNumber)(roundNumber)
  def isComplete():Boolean = !(rows_.last(0) == -1)

  def getRows = this.rows_

  def checkResult(row:List[Int], secret: List[Int]):((Char,Int),(Char,Int)) = {
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
      checkResultAux2(row,secret,0,Nil,Nil)
    }
    checkResultAux(row,secret)
  }

  def isMastermind(turn: Int):Boolean = {
    checkResult(rows_(turn), SecretCombination.getSecretCombination())._1._2 == 4
  }
  def isMastermind(turn: Int, secret: List[Int]):Boolean = {
    checkResult(rows_(turn), secret)._1._2 == 4
  }


  def put(round: List[Int], turn:Int): Board =
    new Board(
      rows_.zipWithIndex.map {
        case (row,position) =>
          if (position != turn)
            row
          else
            round
      })

}

package views

import models.{Board, SecretCombination}

object BoardView {
  def write(board: Board) = {
    def toPrint(result:String, rows: List[List[Int]]):String = {
      rows match {
        case Nil => result
        case head :: _ if (head == rows.head) => toPrint(result +
                                              RoundView.writeComb(rows.head) +
                                              writeResult(board.checkResult(rows.head, SecretCombination.getSecretCombination())),
                                                          rows.tail )
      }
    }
    toPrint("",board.getRows)
  }
  def writeResult(result: ((Char,Int),(Char,Int))) =
    print(" Dead: " + result._1._2 + " Injured: " + result._2._2 + "\n")
}

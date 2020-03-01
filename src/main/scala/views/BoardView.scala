package views

import models.Color.Color
import models.{Board, SecretCombination}

object BoardView {
  def write(board: Board) = {
    def toPrint(result:String, rows: List[List[Color]]):String = {
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
  def writeResult(result: ((Color,Int),(Color,Int))) =
    print( result._1._1 + ": " + result._1._2 + " "+ result._2._1 + ": "+ result._2._2 + "\n")
}

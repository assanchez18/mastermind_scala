package views

import models.{Board, Combination}

object BoardView {
  def write(board: Board) = {
    def print(result:String, rows:List[Combination]):String = {
      rows match {
        case Nil => result
        case head :: _ if (head == rows.head) => print(result + RoundView.writeComb(head), rows.tail )
      }
    }
    print("",board.getRows)
  }

}

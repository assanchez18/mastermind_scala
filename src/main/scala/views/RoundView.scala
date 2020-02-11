package views

import models.Round

object RoundView {

  def write(round: Round) = {
    var result = ""
    for(i <- List(0,1,2,3)) {
      val color = round.getColor(i)
      result += ColorView.getChar(color)
    }
    result += "\n"
    print(result)
  }

  def read(roundNumber:Int): Round = {
    var round = ""
    do {
      round = GestorIO.readString("Combination? (R - G - A - O)")
    }while(round.length != 4)
    new Round(strToRound(round.toCharArray,Nil))
  }

  def strToRound(str: Array[Char], round:List[Int]): List[Int] = {
    str.length match {
      case 0 => round
      case _ => strToRound(str.tail, round.appended(ColorView.getNum(str.head)))
    }
  }
}

package views

import models.Combination

object RoundView {

  def writeComb(round: List[Int]) = {
    def readComb(result: String, comb: List[Int]):String = {
      comb match {
        case Nil => result
        case head :: tail => readComb(result.appended(ColorView.getChar(head)),tail)
      }
    }
    print(readComb ("",round) + "\n")
  }

  def read(roundNumber:Int): Combination = {
    var round = ""
    do {
      round = GestorIO.readString("Combination? (R - G - A - O)")
    }while(round.length != 4 || !validInput(round))
    new Combination(strToRound(round.toList,Nil), roundNumber)
  }

  def strToRound(str: List[Char], round:List[Int]): List[Int] = {
    str match {
      case Nil => round
      case _ => strToRound(str.tail, round.appended(ColorView.getNum(str.head)))
    }
  }

  def validInput(str: String) = {
    def validInput2(str:List[Char], list: List[Int]):List[Int] = {
      str match {
        case Nil => list
        case _ => validInput2(str.tail, list.appended(ColorView.getNum(str.head)))
      }
    }
    inRange(validInput2(str.toList, Nil),true)
  }

  def inRange(secret:List[Int], correct:Boolean):Boolean = {
    (secret, correct) match {
      case (Nil, _) => correct
      case (head :: tail, true) => inRange(tail, (head >= 0 && head <=3))
      case (_, false) => correct
    }
  }
}

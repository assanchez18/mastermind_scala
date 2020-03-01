package views

import models.Color
import models.Color.Color

object RoundView {

  def writeComb(round: List[Color]) = {
    def combinationToStr(result: String, comb: List[Color]):String =
      comb match {
        case Nil => result + " "
        case head :: tail => combinationToStr(result.concat(head.toString),tail)
      }
    print(combinationToStr ("",round))
  }

  def read(roundNumber:Int): List[Color] = {
    def strToRound(str: List[Char], round: List[Color]): List[Color] =
      str match {
        case Nil => round
        case _ => strToRound(str.tail,round.appended(Color.charToColor(str.head)))
      }

    def read2(combination: String): List[Char] = {
      if (combination.length == 4 && validInput(combination)) return combination.toList
      else read2(GestorIO.readString("Combination? (R - G - A - O)"))
    }

    strToRound(read2(GestorIO.readString("Combination? (R - G - A - O)")), Nil)
  }

  def validInput(str: String) = {
    def validInput2(str:List[Char], list: List[Color]):List[Color] =
      str match {
        case Nil => list
        case _ => validInput2(str.tail, list.appended(Color.charToColor(str.head)))
      }
    inRange(validInput2(str.toList, Nil))
  }

  def inRange(list:List[Color]):Boolean = {
    list match {
      case Nil => true
      case head :: tail if (head == list.head && head > Color.empty && head < Color.black) => inRange(tail)
      case _ => false
    }
  }
}

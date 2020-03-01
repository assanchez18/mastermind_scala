package views

object RoundView {

  def writeComb(round: List[Int]) = {
    def combinationToStr(result: String, comb: List[Int]):String =
      comb match {
        case Nil => result + " "
        case head :: tail => combinationToStr(result.appended(ColorView.getChar(head)),tail)
      }
    print(combinationToStr ("",round))
  }




  def read(roundNumber:Int): List[Int] = {
    def strToRound(str: List[Char], round: List[Int]): List[Int] =
      str match {
        case Nil => round
        case _ => strToRound(str.tail,round.appended(ColorView.getNum(str.head)))
      }

    def read2(combination: String): List[Char] = {
      if (combination.length == 4 && validInput(combination)) return combination.toList
      else read2(GestorIO.readString("Combination? (R - G - A - O)"))
    }

    strToRound(read2(GestorIO.readString("Combination? (R - G - A - O)")), Nil)
  }

  def validInput(str: String) = {
    def validInput2(str:List[Char], list: List[Int]):List[Int] =
      str match {
        case Nil => list
        case _ => validInput2(str.tail, list.appended(ColorView.getNum(str.head)))
      }

    inRange(validInput2(str.toList, Nil),true)
  }

  def inRange(secret:List[Int], correct:Boolean):Boolean =
    (secret, correct) match {
      case (Nil, _) => correct
      case (head :: tail, true) => inRange(tail, (head >= 0 && head <=3))
      case (_, false) => correct
    }
}

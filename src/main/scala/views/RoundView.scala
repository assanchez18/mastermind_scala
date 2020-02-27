package views

object RoundView {

  def writeComb(round: List[Int]) = {

    def readComb(result: String, comb: List[Int]):String =
      comb match {
        case Nil => result
        case head :: tail => readComb(result.appended(ColorView.getChar(head)),tail)
      }
    print(readComb ("",round) + " ")
  }

  def read(roundNumber:Int): List[Int] = {
    def strToRound(str: List[Char]): List[Int] = {
      def strToRound2(str: List[Char], round: List[Int]): List[Int] = {
        str match {
          case Nil => round
          case _ => strToRound2(str.tail,round.appended(ColorView.getNum(str.head)))
        }
      }
      strToRound2(str, Nil)
    }
  //Duda sobre como poder hacer esto sin doWHile Quizás podemos usar el readComb de arriba?
    var round = ""
    do {
      round = GestorIO.readString("Combination? (R - G - A - O)")
    }while(round.length != 4 || !validInput(round))
    strToRound(round.toList)
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

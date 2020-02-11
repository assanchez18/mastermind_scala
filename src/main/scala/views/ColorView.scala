package views

object ColorView {
  def getChar(color:Int):Char =
    color match {
      case -1 => '-'
      case 0 => 'R'
      case 1 => 'G'
      case 2 => 'A'
      case 3 => 'O'
      case 4 => 'B'
      case 5 => 'W'
      //case _ => 'X'
    }

  def getNum(color:Char):Int =
    color.toUpper match {
      case '-' => -1
      case 'R' => 0
      case 'G' => 1
      case 'A' => 2
      case 'O' => 3
      case 'B' => 4
      case 'W' => 5
      case _ => 6
    }
}

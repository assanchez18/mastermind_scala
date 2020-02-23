package models

class Board(rows: List[Combination] = List(
  new Combination,
  new Combination,
  new Combination,
  new Combination,
  new Combination,
  new Combination,
  new Combination,
  new Combination,
  new Combination,
  new Combination
)) {

  private val rows_ = rows

  def getColor(roundNumber:Int): Combination = rows_(roundNumber)
  def getRows = this.rows_
  def isMastermind(turn: Int):Boolean = {
    //TODO-logic
    
    false
  }

  def isComplete():Boolean = {
    !rows_.last.isEmpty()
  }

  def put(round: Combination, turn:Int): Board =
    new Board(
      rows_.zipWithIndex.map {
        case (row,position) =>
          if (position != turn)
            row
          else
            round
      })


  /*
  private def getCoordinates(player: Int): List[Coordinate] = {

    def getCoordinates2(player: Int, row: List[Int], fila: Int, columna: Int): List[Coordinate] = {
      row match {
        case Nil => Nil
        case head :: tail => if (head == player)
          new Coordinate(fila, columna) :: getCoordinates2(player, tail, fila, columna + 1)
        else
          getCoordinates2(player, tail, fila, columna + 1)
      }
    }

    def getCoordinates(player: Int, rows: List[List[Int]], fila: Int): List[Coordinate] = {
      rows match {
        case Nil => Nil
        case head :: tail =>
          getCoordinates2(player, head, fila, 0) ++ getCoordinates(player, tail, fila + 1)
      }
    }

    getCoordinates(player, rows_, 0)
  }

  def isComplete: Boolean = this.getCoordinates(-1).length == 3

  // change into is mastermind
  def isMastermind: Boolean = {

  /*  def isTicTacToe(player: Int): Boolean = {

      def equals(strings: List[String]): Boolean =
        strings match {
          case Nil => true
          case _ :: Nil => true
          case first :: second :: tail if (first == second) => equals(second :: tail)
          case _ :: _ => false
        }

      def getDirections(coordinates: List[Coordinate]): List[String] = {
        coordinates match {
          case Nil => Nil
          case head :: Nil => Nil
          case first :: second :: tail => first.getDirection(second) :: getDirections(second :: tail)
        }
      }

      val coordinates = this.getCoordinates(player)
      coordinates.length == 3 && equals(getDirections(coordinates))
    }

    isTicTacToe(0) || isTicTacToe(1)
    */
    false
  }


  override def equals(that: Any): Boolean =
    that match {
      case that: Board =>
        rows_ == that.rows_
      case _ => false
    }

  override def hashCode(): Int = {
    val state = Seq(rows_)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
*/
}

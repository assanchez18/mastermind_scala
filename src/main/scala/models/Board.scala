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
  def isMastermind(turn: Int):Boolean = this.rows_(turn).isMastermind
  def isComplete():Boolean = !rows_.last.isEmpty()

  def put(round: Combination, turn:Int): Board =
    new Board(
      rows_.zipWithIndex.map {
        case (row,position) =>
          if (position != turn)
            row
          else
            round
      })

}

package models

class Game(turn: Int = 0, board: Board = new Board()) {

  private val turn_ = turn

  private val board_ = board

  def getColor(roundNumber:Int): Round = board_.getColor(roundNumber)

  def put(row: Round): Game = {
    val newBoard = this.board_.put(row, this.turn_)
    val newTurn = this.turn_ + 1
    new Game(newTurn, newBoard)
  }

  def isMastermind: Boolean = board_.isMastermind

  def isComplete: Boolean = board_.isComplete

  /*
  def getColor(coordinate:Coordinate):Int = board_.getColor(coordinate)

  def take : Int = turn_.take
*/
}

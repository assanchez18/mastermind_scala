package models

class Game(turn: Int = 0, board: Board = new Board()) {

  private val turn_ = turn

  private val board_ = board

  def getColor(roundNumber:Int): Combination = board_.getColor(roundNumber)

  def put(row: Combination): Game = {
    val newBoard = this.board_.put(row, this.turn_)
    val newTurn = this.turn_ + 1
    new Game(newTurn, newBoard)
  }

  def isMastermind: Boolean = board_.isMastermind(this.turn_)

  def isComplete: Boolean = board_.isComplete

  def getBoard: Board = this.board_
  /*
  def getColor(coordinate:Coordinate):Int = board_.getColor(coordinate)

  def take : Int = turn_.take
*/
}

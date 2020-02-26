package models

class Game(turn: Int = 0, board: Board = new Board()) {

  private val turn_ = turn

  private val board_ = board

  def getColor(roundNumber:Int): Int = board_.getColor(roundNumber)

  def put(row: List[Int]): Game = {
    val newBoard = this.board_.put(row, this.turn_)
    val newTurn = this.turn_ + 1
    new Game(newTurn, newBoard)
  }

  def isMastermind: Boolean = board_.isMastermind(this.turn_ -1)

  def isComplete: Boolean = board_.isComplete

  def getBoard: Board = this.board_

}

package views

import models.Game

object BoardView {
  def write(game: Game) = {
    var result = ""
    for(i <- List(0,1,2,3,4,5,6,7,8,9)) {
      RoundView.write(game.getColor(i))
    }
  }
}

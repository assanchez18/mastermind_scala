import models.Game
import views.{GameView, GestorIO, RoundView}
object Main {

  var game = new Game

  def main(args: Array[String]):Unit = {

    GameView.write(game)
    var times = 0
    do {
      game = game.put(RoundView.read(times))
      GameView.write(game)
      times += 1
    } while (!game.isMastermind && !game.isComplete)
    GestorIO.write("... pero has perdido")
  }

}

import models.{Game, SecretCombination}
import views.{GameView, GestorIO, RoundView}
object Main {

  var game = new Game

  def main(args: Array[String]):Unit = {

    GameView.write(game)
    println("Secret: " + SecretCombination.getSecretCombination())
    var times = 0
    do {
      game = game.put(RoundView.read(times))
      GameView.write(game)
      times += 1
    } while (!game.isMastermind && !game.isComplete)
    if (!game.isMastermind) GestorIO.write("... pero has perdido") else GestorIO.write("... Victoria!")
  }

}

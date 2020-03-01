package models

import scala.util.Random

object Color extends Enumeration {

  type Color = Value

  val empty = Value("- ")
  val red = Value("Red ")
  val green = Value("Green ")
  val blue = Value("Blue ")
  val orange = Value("Orange ")
  val black = Value("Dead")
  val white = Value("Injured")
  val error = Value("X")

  def random: Color = {
    val random = new Random
    Color.values.toList(random.between(1,5))
  }

  def charToColor(color:Char):Color =
    color.toUpper match {
      case '-' => Color.empty
      case 'R' => Color.red
      case 'G' => Color.green
      case 'A' => Color.blue
      case 'O' => Color.orange
      case 'B' => Color.black
      case 'W' => Color.white
      case _ => Color.error
    }

}

package models
import Color.Color

object SecretCombination  {

  private val secretCombination_ = randomCombination(Nil)
  private def randomCombination(list:List[Color]): List[Color] =
    list.size match {
      case 4 => list
      case _ => randomCombination(list.appended(Color.random))
  }
  
  def getSecretCombination():List[Color] = this.secretCombination_
}
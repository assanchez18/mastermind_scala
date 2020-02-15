package models

object SecretCombination  {

  private val secretCombination_ = randomCombination(Nil)
  private def randomCombination(list:List[Int]): List[Int] = {
    val r = scala.util.Random
    list.size match {
      case 4 => list
      case _ => randomCombination(list.appended(r.nextInt(4)))
    }
  }
  
  def getSecretCombination():List[Int] = this.secretCombination_
}
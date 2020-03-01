import models.Color.Color
import models.{Color, SecretCombination}
import org.scalatest.FunSuite
import views.RoundView

class ColorTest extends FunSuite{

  test("Generate secret combination in range") {
    assert(RoundView.inRange(SecretCombination.getSecretCombination()), "Secret combination is wrong generated. Some values are out of range. " + SecretCombination.getSecretCombination())
  }

}

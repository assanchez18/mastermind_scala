import models.SecretCombination
import org.scalatest.FunSuite
import views.RoundView

class CombinationTest extends FunSuite {

  test("Create secret Combination with possible colors") {
    assert(RoundView.inRange(SecretCombination.getSecretCombination,true),
      "The secret Combination is not correctly generated: " + RoundView.writeComb(SecretCombination.getSecretCombination))
  }
}

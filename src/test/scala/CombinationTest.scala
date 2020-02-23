import models.{Combination, SecretCombination,Board}
import org.scalatest.FunSuite
import views.RoundView

class CombinationTest extends FunSuite {

  test("Create secret Combination with possible colors") {
    assert(RoundView.inRange(SecretCombination.getSecretCombination,true),
      "The secret Combination is not correctly generated: " + RoundView.writeComb(SecretCombination.getSecretCombination))
  }

  test("Count injured and dead ") {
    def matchTuple(result:((Char,Int),(Char,Int)),expected:((Char,Int),(Char,Int))):Boolean = {
      (result._1._2 == expected._1._2) && (result._2._2 == expected._2._2)
    }

    val comb = new Combination(List(0,1,2,3))
    val sec = new Combination(List(0,0,1,1))

    val expectedResult = (('B',1),('W',1))
    assert(matchTuple(comb.checkResult(sec.row), expectedResult),
            "Checking result error, expected " + expectedResult._1._2 + " Deaths and " + expectedResult._2._2 + " Injured and received "
           + comb.checkResult(sec.row)._1._2 + " Deaths and " + comb.checkResult(sec.row)._2._2 + " Injured.")

    val comb2 = new Combination(List(0,0,2,3),0)
    val sec2 = new Combination(List(0,0,1,1),0)

    val expectedResult2 = (('B',2),('W',0))
    assert(matchTuple(comb2.checkResult(sec2.row), expectedResult2),
      "Checking result error, expected " + expectedResult2._1._2 + " Deaths and " + expectedResult2._2._2 + " Injured and received "
        + comb2.checkResult(sec2.row)._1._2 + " Deaths and " + comb2.checkResult(sec2.row)._2._2 + " Injured.")
  }
}

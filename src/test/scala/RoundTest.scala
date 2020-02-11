import org.scalatest.FunSuite
import views.RoundView

class RoundTest extends FunSuite {

  test("read one Round") {
    //val Round = new Board()
    //RGAO

    val round = RoundView.read(0)
    assert(round.row == List(1,2,3,4) && round.roundNumber == 0)
  }
}

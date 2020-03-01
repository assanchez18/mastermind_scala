import models.Color.Color
import models.{Board, Color}
import org.scalatest.FunSuite


class BoardTest extends FunSuite {
  test("Given a row and the secret combination check if is Mastermind") {
    var board = new Board
    val sec = List(Color.red, Color.green, Color.blue, Color.orange)
    board = board.put(List(Color.red, Color.green, Color.blue, Color.orange),0)
    assert(board.isMastermind(0,sec),
      "Error calculating Result only " + board.checkResult(board.getRows(0), sec)._1._2 + " dead.")
  }

  test("Given different rows then count injured and dead ") {
    def matchTuple(result: ((Color, Int), (Color, Int)), expected: ((Color, Int), (Color, Int))): Boolean = {
      (result._1._2 == expected._1._2) && (result._2._2 == expected._2._2)
    }
    val board = new Board
    val comb = List(Color.red, Color.green, Color.blue, Color.orange)
    val sec = List(Color.red, Color.red, Color.green, Color.green)

    val expectedResult = ((Color.black, 1), (Color.white, 1))
    assert(matchTuple(board.checkResult(comb, sec), expectedResult),
      "Checking result error, expected " + expectedResult._1._2 + " Deaths and " + expectedResult._2._2 + " Injured and received "
        + board.checkResult(comb, sec)._1._2 + " Deaths and " + board.checkResult(comb, sec)._2._2 + " Injured.")

    val comb2 = List(Color.red, Color.red, Color.blue, Color.orange)
    val sec2 = List(Color.red, Color.red, Color.green, Color.green)

    val expectedResult2 = ((Color.black, 2), (Color.white, 0))
    assert(matchTuple(board.checkResult(comb2, sec2), expectedResult2),
      "Checking result error, expected " + expectedResult2._1._2 + " Deaths and " + expectedResult2._2._2 + " Injured and received "
        + board.checkResult(comb2,sec2)._1._2 + " Deaths and " + board.checkResult(comb2,sec2)._2._2 + " Injured.")


    val comb3 = List(Color.green, Color.red, Color.red, Color.blue)
    val sec3 = List(Color.red, Color.red, Color.blue, Color.green)

    val expectedResult3 = ((Color.black, 1), (Color.white, 3))
    assert(matchTuple(board.checkResult(comb3, sec3), expectedResult3),
      "Checking result error, expected " + expectedResult3._1._2 + " Deaths and " + expectedResult3._2._2 + " Injured and received "
        + board.checkResult(comb3,sec3)._1._2 + " Deaths and " + board.checkResult(comb3,sec3)._2._2 + " Injured.")
  }

  test("Given an empty board when put a new row then row is added") {
    var board = new Board
    assert(board.getRows.head.head == Color.empty, "Board has not been created empty!")
    board = board.put(List(Color.red, Color.red, Color.red, Color.red),0)
    assert(board.getRows.head.head == Color.red, "Board has not put the new row properly!")
  }

  test("Given an empty board when put 10 rows then board complete") {
    var board = new Board
    assert(board.getRows.head.head == Color.empty, "Board has not been created empty!")
    for (i <- 0 to 9)
      board = board.put(List(Color.red, Color.red, Color.red, Color.red), i)
    assert(board.isComplete, "Board is not complete, some rows can be missing!")
  }
}


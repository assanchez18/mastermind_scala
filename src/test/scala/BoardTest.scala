import models.Board
import org.scalatest.FunSuite


class BoardTest extends FunSuite {
  test("Given a row and the secret combination check if is Mastermind") {
    var board = new Board
    val sec = List(0, 1, 2, 3)
    board = board.put(List(0,1,2,3),0)
    assert(board.isMastermind(0,sec),
      "Error calculating Result only " + board.checkResult(board.getRows(0), sec)._1._2 + " dead.")
  }

  test("Given different rows then count injured and dead ") {
    def matchTuple(result: ((Char, Int), (Char, Int)), expected: ((Char, Int), (Char, Int))): Boolean = {
      (result._1._2 == expected._1._2) && (result._2._2 == expected._2._2)
    }
    val board = new Board
    val comb = List(0, 1, 2, 3)
    val sec = List(0, 0, 1, 1)

    val expectedResult = (('B', 1), ('W', 1))
    assert(matchTuple(board.checkResult(comb, sec), expectedResult),
      "Checking result error, expected " + expectedResult._1._2 + " Deaths and " + expectedResult._2._2 + " Injured and received "
        + board.checkResult(comb, sec)._1._2 + " Deaths and " + board.checkResult(comb, sec)._2._2 + " Injured.")

    val comb2 = List(0, 0, 2, 3)
    val sec2 = List(0, 0, 1, 1)

    val expectedResult2 = (('B', 2), ('W', 0))
    assert(matchTuple(board.checkResult(comb2, sec2), expectedResult2),
      "Checking result error, expected " + expectedResult2._1._2 + " Deaths and " + expectedResult2._2._2 + " Injured and received "
        + board.checkResult(comb2,sec2)._1._2 + " Deaths and " + board.checkResult(comb2,sec2)._2._2 + " Injured.")


    val comb3 = List(1, 0, 0, 2)
    val sec3 = List(0, 0, 2, 1)

    val expectedResult3 = (('B', 1), ('W', 3))
    assert(matchTuple(board.checkResult(comb3, sec3), expectedResult3),
      "Checking result error, expected " + expectedResult3._1._2 + " Deaths and " + expectedResult3._2._2 + " Injured and received "
        + board.checkResult(comb3,sec3)._1._2 + " Deaths and " + board.checkResult(comb3,sec3)._2._2 + " Injured.")
  }

  test("Given an empty board when put a new row then row is added") {
    var board = new Board
    assert(board.getRows.head.head == -1, "Board has not been created empty!")
    board = board.put(List(0,0,0,0),0)
    assert(board.getRows.head.head == 0, "Board has not put the new row properly!")
  }

  test("Given an empty board when put 10 rows then board complete") {
    var board = new Board
    assert(board.getRows.head.head == -1, "Board has not been created empty!")
    for (i <- 0 to 9)
      board = board.put(List(0,0,0,0),i)
    assert(board.isComplete, "Board is not complete, some rows can be missing!")
  }
}


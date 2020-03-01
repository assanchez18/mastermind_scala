package models

import models.Color.Color

class Board(rows: List[List[Color]] = List(
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty),
  List(Color.empty,Color.empty,Color.empty,Color.empty)
)) {

  private val rows_ = rows
  def isComplete():Boolean = !(rows_.last(0) == Color.empty)

  def getRows: List[List[Color]] = this.rows_

  def checkResult(row:List[Color], secret: List[Color]):((Color,Int),(Color,Int)) = {
    def checkResultAux(row:List[Color],secret:List[Color]):((Color,Int),(Color,Int)) = {

      def checkResultAux2(row:List[Color],secret:List[Color], dead:Int, remainingRow:List[Color], remainingSec:List[Color]):((Color,Int),(Color,Int)) = {

        def countInjured(row:List[Color],secret:List[Color], injure:Int):(Color,Int) =
          row match {
            case Nil => (Color.white,injure)
            case head :: tail if(secret.contains(head)) => countInjured(tail,secret.patch(secret.indexOf(head),Seq(Color.empty),1), injure+1)
            case _ :: tail => countInjured(tail, secret, injure)
          }

        row match {
          case Nil => ((Color.black,dead), countInjured(remainingRow, remainingSec,0))
          case head :: tail if (head == secret.head) => checkResultAux2(tail, secret.tail, dead+1, remainingRow, remainingSec)
          case _ :: tail => checkResultAux2(tail, secret.tail, dead, remainingRow.appended(row.head), remainingSec.appended(secret.head))
        }
      }
      checkResultAux2(row,secret,0,Nil,Nil)
    }
    checkResultAux(row,secret)
  }

  def isMastermind(turn: Int):Boolean = {
    checkResult(rows_(turn), SecretCombination.getSecretCombination())._1._2 == 4
  }
  def isMastermind(turn: Int, secret: List[Color]):Boolean = {
    checkResult(rows_(turn), secret)._1._2 == 4
  }


  def put(round: List[Color], turn:Int): Board =
    new Board(
      rows_.zipWithIndex.map {
        case (row,position) =>
          if (position != turn)
            row
          else
            round
      })

}

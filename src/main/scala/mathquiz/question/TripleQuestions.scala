package mathquiz.question

import mathquiz.Question

import scala.util.Random


object TripleQuestions {
  val all = ABQMultipleQuestion ::
    ABQAddQuestion ::
    ABQDivideQuestion ::
    AQBMultipleQuestion ::
    AQBAddQuestion ::
    AQBDivideQuestion ::
    QBCMultipleQuestion ::
    QBCAddQuestion ::
    QBCDivideQuestion :: Nil
}

case class TripleEquation(a:Int, b:Int, c:Int)

trait Multiply {
  def generate:TripleEquation = {
    val a = Random.nextInt(10)
    val b = Random.nextInt(10)
    TripleEquation(a,b,a*b)
  }
  val symbol = "×"
}

trait Add {
  def generate:TripleEquation = {
    val a = Random.nextInt(10)
    val b = Random.nextInt(10)
    TripleEquation(a,b,a+b)
  }
  val symbol = "+"
}


trait Divide {
  def generate:TripleEquation = {
    val b = Random.nextInt(9)+1
    val c = Random.nextInt(10)
    TripleEquation(b*c,b,c)
  }
  val symbol = "÷"
}

trait ABTripleQuestion extends Question {
  def generate:TripleEquation
  val symbol:String
  def text = {
    val t = generate
    s"${t.a} $symbol ${t.b} = ?"
  }
}

trait ACTripleQuestion extends Question {
  def generate:TripleEquation
  val symbol:String
  def text = {
    val t = generate
    s"${t.a} $symbol ? = ${t.c}"
  }
}


trait BCTripleQuestion extends Question {
  def generate:TripleEquation
  val symbol:String
  def text = {
    val t = generate
    s"? $symbol ${t.b} = ${t.c}"
  }
}

object ABQMultipleQuestion extends ABTripleQuestion with Multiply

object ABQAddQuestion extends ABTripleQuestion with Add

object ABQDivideQuestion extends ABTripleQuestion with Divide

object AQBMultipleQuestion extends ACTripleQuestion with Multiply

object AQBAddQuestion extends ACTripleQuestion with Add

object AQBDivideQuestion extends ACTripleQuestion with Divide

object QBCMultipleQuestion extends BCTripleQuestion with Multiply

object QBCAddQuestion extends BCTripleQuestion with Add

object QBCDivideQuestion extends BCTripleQuestion with Divide
package mathquiz.question

import mathquiz.Question

import scala.util.Random

object TripleQuestions {
  val all = ABQMultipleQuestion ::
    ABQAddQuestion ::
    ABQDivideQuestion ::
    AQBMultipleQuestion ::
    AQBAddQuestion ::
    AQBDivideQuestion :: Nil
}

object ABQMultipleQuestion extends Question {
  def text = {
    val a = Random.nextInt(10)
    val b = Random.nextInt(10)
    ""+a+" × "+b + " = ?"
  }
}

object ABQAddQuestion extends Question {
  def text = {
    val a = Random.nextInt(10)
    val b = Random.nextInt(10)
    ""+a+" + "+b + " = ?"
  }
}

object ABQDivideQuestion extends Question {
  def text = {
    val b = Random.nextInt(9)+1
    val t = Random.nextInt(10)
    val a = b * t
    ""+a+" ÷ "+b + " = ?"
  }
}

object AQBMultipleQuestion extends Question {
  def text = {
    val a = Random.nextInt(10)
    val b = Random.nextInt(10)
    val q = a * b
    ""+a+" × ? = "+q
  }
}


object AQBAddQuestion extends Question {
  def text = {
    val a = Random.nextInt(10)
    val b = Random.nextInt(10)
    val q = a + b
    ""+a+" + ? = "+q
  }
}


object AQBDivideQuestion extends Question {
  def text = {
    val b = Random.nextInt(9) + 1
    val q = Random.nextInt(10)
    val a = b * q
    ""+a+" + ? = "+q
  }
}

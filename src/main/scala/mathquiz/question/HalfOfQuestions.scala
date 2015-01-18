package mathquiz.question

import mathquiz.Question

import scala.util.Random

object HalfOfQuestions {
  val all = HalfOfQuestionHiddenTarget :: HalfOfQuestionShownTarget :: Nil
}



object HalfOfQuestionHiddenTarget extends Question {
  def text = "½ of " + (Random.nextInt(50) * 2) + " = ?"
}

object HalfOfQuestionShownTarget extends Question {
  def text = "½ of ? = " + Random.nextInt(50)
}

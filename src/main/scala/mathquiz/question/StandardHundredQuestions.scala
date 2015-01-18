package mathquiz.question

import mathquiz.Question

object StandardHundredQuestions {
  val all = MultiplyByTenToGetAHundredQuestion :: DivideByTenToGetAHundredQuestion :: Nil
}


object MultiplyByTenToGetAHundredQuestion extends Question {
  def text = "? × 10 = 100"
}

object DivideByTenToGetAHundredQuestion extends Question {
  def text = "100 ÷ ? = 10"
}

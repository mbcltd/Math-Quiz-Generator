package mathquiz

import mathquiz.question.{TripleQuestions, StandardHundredQuestions, HalfOfQuestions}

import scala.util.Random

object Questions {
  def all:List[Question] = HalfOfQuestions.all ::: StandardHundredQuestions.all ::: TripleQuestions.all

  def random = Random.shuffle(all).head

  def randomText = random.text

  def randomTextNotInList(l:List[String]):String = {
    val t = randomText
    if(l.contains(t)) randomTextNotInList(l) else t
  }

  def randomText(size:Int): List[String] = randomText(size,Nil)

  def randomText(size:Int, l:List[String]): List[String] = if(size==0) l else randomText( size -1, randomTextNotInList(l) :: l)
}

trait Question {
  def text:String
}







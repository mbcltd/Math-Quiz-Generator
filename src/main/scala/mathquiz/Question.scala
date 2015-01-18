package mathquiz

import scala.util.Random

object Main extends App {
   Questions.randomText(20).foreach( println )
}

object MainLatex extends App {
  val qs = Questions.randomText(60)

  val header =
    """
      |\documentclass{article}
      |
      |\begin{document}
      |
      |TABLES TEST
      |
      |Name: ...............................
      |Time: 4 minutes
      |Score: ................./60
      |
      |
      |\begin{center}
      |  \begin{tabular}{ | l | c | r | l | c | r | l | c | r | }
      |    \hline
      |
    """.stripMargin

  val footer =
    """
      |
      |  \end{tabular}
      |\end{center}
      |
      |\end{document}
      |
    """.stripMargin

  val content = qs.zipWithIndex.grouped(3).map( toLatexTable ).mkString("\n").replaceAllLiterally("×","$\\times$").replaceAllLiterally("÷","$\\div$").replaceAllLiterally("½","$\\frac{1}{2}$")

  def toLatexTable(l:List[(String,Int)]) = l.map( toLatexTableElement ).mkString(" & ") + " \\\\ \\hline"

  def toLatexTableElement(t:(String,Int)) = "" + t._2 +". & " + t._1 +" & "

  println(header)
  println(content)
  println(footer)

}



object Questions {
  def all = HalfOfQuestionHiddenTarget ::
    HalfOfQuestionShownTarget ::
    MultiplyByTenToGetAHundredQuestion ::
    DivideByTenToGetAHundredQuestion ::
    ABQMultipleQuestion ::
    ABQAddQuestion ::
    ABQDivideQuestion ::
    AQBMultipleQuestion ::
    AQBAddQuestion ::
    AQBDivideQuestion ::
    Nil

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

object HalfOfQuestionHiddenTarget extends Question {
  def text = "½ of " + (Random.nextInt(50) * 2) + " = ?"
}

object HalfOfQuestionShownTarget extends Question {
  def text = "½ of ? = " + Random.nextInt(50)
}

object MultiplyByTenToGetAHundredQuestion extends Question {
  def text = "? × 10 = 100"
}

object DivideByTenToGetAHundredQuestion extends Question {
  def text = "100 ÷ ? = 10"
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






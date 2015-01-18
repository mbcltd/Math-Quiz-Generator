package mathquiz

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

  def toLatexTableElement(t:(String,Int)) = "" + ( t._2 +1 ) +". & " + t._1 +" & "

  println(header)
  println(content)
  println(footer)

}
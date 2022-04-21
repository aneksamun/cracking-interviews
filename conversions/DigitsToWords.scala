import scala.annotation.tailrec

object DigitsToWords {

  private val Wordings = Array(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  )

  // Converts digits to words, for example, 1985 will be converted to "one nine eight five"
  def convert(n: Int): String = {
    @tailrec
    def convertAccumulatingResult(n: Int, acc: Seq[String]): String = {
      if (n > 0) {
        convertAccumulatingResult(n / 10, Wordings(n % 10) +: acc)
      } else {
        acc.mkString(" ")
      }
    }

    convertAccumulatingResult(n, Seq.empty)
  }
}

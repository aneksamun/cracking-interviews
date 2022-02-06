import scala.annotation.tailrec

object SeqToInt {

  /**
   * Seq(9, 1, 3).toInt == 913.toSeq.mkString(", ")
   */

  implicit class SeqOps(val items: Seq[Int]) extends AnyVal {
    def toInt: Int =
      items.foldLeft(0)((curr, elem) => curr * 10 + elem)
  }

  implicit class IntOps(val i: Int) extends AnyVal {
    def toSeq: Seq[Int] = {

      def splitIntoDecimals2(n: Int): Seq[Int] =
        if (n > 0)
          splitIntoDecimals2(n / 10) :+ n % 10
        else Seq.empty

      splitIntoDecimals2(i)

      @tailrec
      def splitIntoDecimals(n: Int)(res: Seq[Int]): Seq[Int] =
        if (n > 0)
          splitIntoDecimals(n / 10)(n % 10 +: res)
        else res

      splitIntoDecimals(i)(Seq.empty)
    }
  }
}

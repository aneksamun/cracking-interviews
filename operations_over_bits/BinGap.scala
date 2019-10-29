object BinGap {

  /**
    * Converts integer to binary string
    */
  def toBinaryString(n: Int): String =
    Stream.iterate(n)(_ / 2).takeWhile(_ != 0).map(_ % 2).reverse.mkString

  /**
    * Finds the longest gap in binary string (counts zeros between ones)
    * 20 (10100) -> 1
    * 7 (111) -> 0
    * 9 (1001) -> 2
    * 32 (100000) -> 0
    */
  def findLongestBinaryGap(number: Int,
                           longestGapLength: Int = 0,
                           currentGapCount: Int = 0,
                           gapRevealed: Boolean = false): Int = {
    number match {
      case 0 => longestGapLength
      case _ =>
        if ((number & 1) == 0) {
          val count = if (gapRevealed) currentGapCount + 1 else currentGapCount
          findLongestBinaryGap(number >>> 1, longestGapLength, count, gapRevealed)
        }
        else
          findLongestBinaryGap(number >>> 1, currentGapCount.max(longestGapLength), gapRevealed = true)
    }
  }
}

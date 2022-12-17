object Matrix {

  val range = LazyList
    .iterate(128)(_ / 2)
    .takeWhile(_ > 0)
    .toList

  def identifyBit(x: Int, y: Int): Char =
    if ((x & y) == 0) '0' else '1'

  def printLeftToRight() =
    range
      .reverse
      .foreach { i =>
        println(
          range.map(identifyBit(i, _)).mkString("")
        )
      }

  def printRightToLeft() =
    range.foreach { i =>
      println(range.map(identifyBit(i, _)).mkString(""))
    }

  //  00000001
  //  00000010
  //  00000100
  //  00001000
  //  00010000
  //  00100000
  //  01000000
  //  10000000  
  println(printLeftToRight())
 
  //  10000000
  //  01000000
  //  00100000
  //  00010000
  //  00001000
  //  00000100
  //  00000010
  //  00000001
  println(printRightToLeft())
}

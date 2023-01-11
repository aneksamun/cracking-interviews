val range = 
  LazyList
    .iterate(128)(_ / 2)
    .takeWhile(_ > 0)
    .toList

def identifyBit(x: Int, y: Int): Char = 
  if ((x & y) == 0) '0' else '1'

def printLeftToRight() = range.reverse.foreach { i =>
  println(range.map(identifyBit(i, _)).mkString(""))
}

def printRightToLeft() = range.foreach { i =>
  println(range.map(identifyBit(i, _)).mkString(""))
}

@main def matrix() =
  printRightToLeft()
  println()
  printLeftToRight()


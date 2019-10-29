object Difference {

  /**
    * Finds min difference in the series of numbers
    * (3, 1, 2, 4, 3) =>
    * (3 - (1 + 2 + 4 + 3)) = |7|
    * ((3 + 1) - (2 + 4 + 3)) = |5|
    * ((3 + 1 + 2) - (4 + 3)) = |1|
    * ((3 + 1 + 2 + 4) - 3) = |7|
    * Answer: 1
    */
  def findMinDifference(numbers: Array[Int]): Int = {
    var left = numbers.head
    var right = numbers.takeRight(numbers.length - 1).sum
    var min = (left - right).abs

    (1 until numbers.length - 1).foreach  { i =>
      val current = numbers(i)
      left += current
      right -= current
      min = (left - right).abs.min(min)
    }

    min
  }
}

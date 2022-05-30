object FindElement {

  /**
    * Finds missing element in the array.
    * (2, 3, 1, 5) -> 4
    */
  def findMissingElement(array: Array[Int]): Int = {
    val allElementsLength = array.length + 1
    val allElementsSum = (allElementsLength * (allElementsLength + 1)) / 2
    allElementsSum - array.sum
  }

  /**
    * Finds the next minimal missing positive integer from the sequence
    * (1, 3, 6, 4, 1, 2) -> 5
    * (1, 2, 3) -> 4
    * (-1, -3) -> 1
    */
  def minPos(array: Array[Int]): Int = {
    val unique = array.filter(_ > 0).toSet
    (1 to array.length + 1).filterNot(unique.contains).head
  }
}

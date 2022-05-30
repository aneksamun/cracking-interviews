// Finds unique element.
// (9, 3, 9, 3, 9, 7, 9) -> 7

object LonelyInt {
  def findUnique(array: Iterable[Int]): Int = {
    array.reduceLeft((prev, curr) => prev ^ curr)  
  }
}

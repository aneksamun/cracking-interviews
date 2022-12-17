
object LonelyInt {
  def findUnique(array: Iterable[Int]): Int = {
    array.reduceLeft((prev, curr) => prev ^ curr)  
  }
}

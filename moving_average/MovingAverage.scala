
object MovingAverage {

  def calculate(numbers: Seq[Int], window: Int): Array[Double] = {
    val movingAverage = Array.ofDim[Double]((numbers.size - window) + 1)

    for (i <- movingAverage.indices) {
      val indexOfLast = i + window
      val slice = numbers.slice(i, indexOfLast)
      movingAverage(i) = slice.sum / slice.length.toDouble
    }

    movingAverage
  }
}

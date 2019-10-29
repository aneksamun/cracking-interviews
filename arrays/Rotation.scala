object Rotation {

  /**
    * Rotates an array K times
    * (A = (3, 8, 9, 7, 6), K = 3) -> (9, 7, 6, 3, 8)
    * (A = (1, 2, 3, 4), K = 4) -> (1, 2, 3, 4))
    */
  def rotateArray(array: Array[Int], k: Int): Array[Int] = {
    val rotated = Array.fill(array.length)(0)
    for (i <- array.indices) {
      rotated((i + k) % array.length) = array(i)
    }
    rotated
  }
}

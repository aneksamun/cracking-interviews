object FrogJumps {

  /**
    * Counts minimal number of jumps from position X to Y.
    * (x = 10, y = 85, d = 30) => 85 - 10 / 30
    */
  def minFrogJumps(x: Int, y: Int, jump: Int): Int = {
    (y - x) / jump.doubleValue() match {
      case n if n <= 0 => 0
      case n if (n - n.intValue()) > 0 => n.intValue() + 1
      case n => n.intValue()
    }
  }
}

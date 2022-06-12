object ab {

  def `weather A is always in front of B`(s: String): Boolean =
    (s.lastIndexOf('a'), s.lastIndexOf('b')) match {
      case (a, b) if a < b => true
      case (_, -1) => true
      case _ => false
    }

}

// Detects lonely integer
// findLonelyInt(1 :: 1 :: 2 :: 3 :: 3 :: Nil)
// 2

object LonelyInt {

  def findLonelyInt(ns: Iterable[Int]): Int = 
    ns.foldLeft(0) { case (prev, curr) => prev ^ curr }
    
}

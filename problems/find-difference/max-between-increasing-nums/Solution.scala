def maximumDifference(nums: Array[Int]): Int =
  nums.scanLeft(Int.MaxValue)(_ min _)
    .tail
    .zip(nums)
    .map { case (min, elem) => elem - min }
    .filter(_ != 0)
    .foldLeft(-1)(_ max _)


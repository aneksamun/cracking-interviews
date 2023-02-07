### <ins>Max difference between increasing elements</ins>

Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Algorithm:
```scala
def maximumDifference(nums: Array[Int]): Int =
  nums.scanLeft(Int.MaxValue)(_ min _)
    .tail
    .zip(nums)
    .map { case (min, elem) => elem - min }
    .filter(_ != 0)
    .foldLeft(-1)(_ max _)
```

Examples:
|Input        | Result | 
|-------------|--------|
|[7, 1, 5, 4] |  4     | 
|[9, 4, 3, 2] | -1     |
|[1, 5, 2, 10]|  9     |

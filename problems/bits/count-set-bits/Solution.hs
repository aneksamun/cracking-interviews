
countPopulation :: Integral a => a -> Int
countPopulation n =
  length $
    filter (== 1) $
      map (`mod` 2) $
        takeWhile (> 0) $
          iterate (`div` 2) n


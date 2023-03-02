
odds :: Int -> [Int]
odds n = map next [0 .. n - 1]
  where 
    next x = x * 2 + 1


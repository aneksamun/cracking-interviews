
pascalTriangle :: Int -> [[Int]]
pascalTriangle n = map (\x -> map (choose x) [0 .. x]) [0 .. n - 1]
  where
    choose n k = product [n - k + 1 .. n] `div` product [1 .. k]

nextRow :: Num a => [a] -> [a]
nextRow xs = zipWith (+) (0 : xs) (xs ++ [0])

triangle :: [[Integer]]
triangle = iterate nextRow [1]


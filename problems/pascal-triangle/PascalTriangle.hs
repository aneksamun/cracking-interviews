-- pascalTriangle 7
-- [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1],[1,6,15,20,15,6,1]]

-- take 7 triangle
-- [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1],[1,6,15,20,15,6,1]]

-- triangle !! 7
-- [1,7,21,35,35,21,7,1]

pascalTriangle :: Int -> [[Int]]
pascalTriangle n = map (\x -> map (choose x) [0 .. x]) [0 .. n - 1]
  where
    choose n k = product [n - k + 1 .. n] `div` product [1 .. k]

nextRow :: Num a => [a] -> [a]
nextRow xs = zipWith (+) (0 : xs) (xs ++ [0])

triangle :: [[Integer]]
triangle = iterate nextRow [1]


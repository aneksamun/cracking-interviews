
average :: [Int] -> Int
average ns = sum' ns `div` length ns

-- same as: div (sum ns)(length ns)

-- sum' :: Num a => [a] -> a
-- sum' [] = 0
-- sum' (n:ns) = n + sum' ns

sum' :: (Foldable t, Num b) => t b -> b
sum' = foldl (+) 0

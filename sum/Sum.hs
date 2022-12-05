
-- sum' :: Num a => [a] -> a
-- sum' [] = 0
-- sum' (n:ns) = n + sum' ns

sum' :: (Foldable t, Num b) => t b -> b
sum' = foldl (+) 0

-- sumFromZeroToN :: (Num b, Enum b) => b -> b
-- sumFromZeroToN n = sum' [1..n]

sumFromZeroToN :: Integral a => a -> a
sumFromZeroToN n = n * (n + 1) `div` 2

-- Usage: ghci Factorial.hs
-- factorial 5

factorial :: (Num a, Enum a) => a -> a
factorial n = product [1..n]

-- product :: Num a => [a] -> a
-- product [] = 1
-- product (n:ns) = n * product ns

-- product :: (Foldable t, Num a) => t a -> a
-- product = foldl (*) 1


-- Usage: ghci Factorial.hs
-- factorial 5

factorial :: (Num a, Enum a) => a -> a
factorial n = product [1..n]

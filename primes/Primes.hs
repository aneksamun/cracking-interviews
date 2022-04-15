-- Factors are the numbers which divides the number without a remainder 
-- factors 8 [1,2,4,8]
-- factors 9 [1,3,9]

factors :: Int -> [Int]
factors n = [x | x <- [1..n], n `mod` x == 0]

-- Primes are the numbers which divides with self and 1 
-- prime 7 => True
-- prime 9 => False

prime :: Int -> Bool
prime n = factors n == [1, n]

-- Get all primes up to n
primes :: Int -> [Int]
primes n = [x | x <- [1..n], prime x]
-- primes n = [1 .. n] >>= (\x -> if prime x then return x else [])

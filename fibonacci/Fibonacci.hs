-- Fibonacci seq = {1, 2, 3, 5, 8, 13, 21, ..., n}

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci(n - 1) + fibonacci(n - 2)

fibs :: Int -> [Int]
fibs n = 0 : map fst (drop 2 $ take (n + 1) $ iterate (\(a, b) -> (b, a + b)) (0, 1))

fibs2 = 1 : 1 : zipWith (+) fibs2 (tail fibs2)
-- fibs2 !! 6 => 13

fibs3 = 1 : 1 : [ a + b | (a, b) <- zip fibs3 (tail fibs3) ]
-- fibs3 !! 4 => 5

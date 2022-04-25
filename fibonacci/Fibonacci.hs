-- Fibonacci seq: 1, 2, 3, 5, 8, 13, 21 ... n

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci(n - 1) + fibonacci(n - 2)

fibs :: Int -> [Int]
fibs n = 0 : map fst (drop 2 $ take (n + 1) $ iterate (\(a, b) -> (b, a + b)) (0, 1))

fibNumAt = 1 : 1 : zipWith (+) fibNumAt (tail fibNumAt)
-- fibNumAt !! 6 => 13

fibNumAt' = 1 : 1 : [ a + b | (a, b) <- zip fibNumAt' (tail fibNumAt') ]
-- fibNumAt' !! 4 => 5

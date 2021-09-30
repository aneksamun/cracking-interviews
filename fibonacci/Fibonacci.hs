
fibs :: Int -> [Int]
fibs n = 0 : map fst (drop 2 $ take (n + 1) $ iterate (\(a, b) -> (b, a + b)) (0, 1))

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci(n - 1) + fibonacci(n - 2)

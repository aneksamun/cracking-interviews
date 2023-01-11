
fibsRecursive :: (Eq a, Num a, Num p) => a -> p
fibsRecursive 0 = 0
fibsRecursive 1 = 1
fibsRecursive n = fibsRecursive (n - 1) + fibsRecursive (n - 2)

fibonacciIter :: Int -> [Int]
fibonacciIter n = 0 : map fst (drop 2 $ take (n + 1) $ iterate (\(a, b) -> (b, a + b)) (0, 1))

fibonacci :: [Integer]
fibonacci = 1 : 1 : zipWith (+) fibonacci (tail fibonacci)

fibonacci' :: [Integer]
fibonacci' = 1 : 1 : [a + b | (a, b) <- zip fibonacci' (tail fibonacci')]



find :: Eq a => a -> [a] -> [Int]
find x xs = [i | (x', i) <- zip xs [0 ..], x == x']

findTupled :: Eq a => a -> [(a, b)] -> [b]
findTupled k t = [v | (k', v) <- t, k == k']


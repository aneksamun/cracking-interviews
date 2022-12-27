-- pairs [1, 2, 3, 4]
-- [(1,2),(2,3),(3,4)]
pairs :: [a] -> [(a, a)]
pairs xs = xs `zip` tail xs

isSorted :: Ord a => [a] -> Bool
isSorted xs = and [x <= y | (x, y) <- pairs xs]


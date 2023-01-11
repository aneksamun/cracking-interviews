
pairs :: [a] -> [(a, a)]
pairs xs = xs `zip` tail xs

isSorted :: Ord a => [a] -> Bool
isSorted xs = and [x <= y | (x, y) <- pairs xs]


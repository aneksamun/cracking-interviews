
-- pairs [1, 2, 3, 4]
-- [(1,2),(2,3),(3,4)]
pairs :: [a] -> [(a, a)]
pairs xs = xs `zip` tail xs

-- sorted [1, 2, 3, 4]
-- True
-- sorted [1, 2, 4, 3]
-- False
sorted :: Ord a => [a] -> Bool
sorted xs = and [x <= y | (x, y) <- pairs xs]


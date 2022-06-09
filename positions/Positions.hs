-- Finds all occurring positions for given item within list of the items
-- positions False [True, False, True, False]
-- [1,3]

positions :: Eq a => a -> [a] -> [Int]
positions x xs = [i | (x', i) <- zip xs [0 ..], x == x']

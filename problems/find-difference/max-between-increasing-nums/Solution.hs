-- Notes:
--  Given [7, 1, 5, 4] 
--  * Finds minimal element at each position: [7, 1, 1, 1]
--  * Combines it with given numbers: [(7,7), (1,1), (5,1), (4,1)]
--  * Subtracts them in between: [0, 0, 4, 3]
--  * Filters zeros out to respond with -1 if no difference found
-- 
-- Side note:
--  zipWith (-) <*> scanl1 min 
--  zipWith (-) ns (scanl1 min ns)

maximumDifference :: [Integer] -> Integer
maximumDifference = 
    foldl max (-1) . filter (/= 0) . (zipWith (-) <*> scanl1 min)


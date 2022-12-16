-- listToInt [9, 1, 3]
-- 913
-- intToList 913
-- [9,1,3]

listToInt :: (Foldable t, Num a) => t a -> a
listToInt = foldl (\acc n -> acc * 10 + n) 0

intToList :: Integral a => a -> [a]
intToList 0 = []
intToList n = intToList (n `div` 10) ++ [n `mod` 10] 

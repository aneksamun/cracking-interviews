
multipleOf :: Int -> Int -> Bool
multipleOf x y = x `mod` y == 0

-- findMultiples 999 [3, 5]
-- [3,5,6,9,10,12,15,18,20,21,24,25..999]

findMultiples :: Foldable t => Int -> t Int -> [Int]
findMultiples n ns = [x | x <- [1..n], any (multipleOf x) ns]

-- sumMultiples 999 [3, 5]
-- 233168

sumMultiples :: Foldable t => Int -> t Int -> Int
sumMultiples n ns = sum $ findMultiples n ns

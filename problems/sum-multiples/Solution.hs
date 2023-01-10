
multipleOf :: Int -> Int -> Bool
multipleOf x y = x `mod` y == 0

findMultiples :: Foldable t => Int -> t Int -> [Int]
findMultiples n ns = [x | x <- [1..n], any (multipleOf x) ns]

sumMultiples :: Foldable t => Int -> t Int -> Int
sumMultiples n ns = sum $ findMultiples n ns


 -- Euler problem #1:
 -- If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 -- The sum of these multiples is 23.
 -- Find the sum of all the multiples of 3 or 5 below 1000.

-- findMultiples 999 [3, 5]
-- [3,5,6,9,10,12,15,18,20,21,24,25..999]

multipleOf :: Int -> Int -> Bool
multipleOf x y = x `mod` y == 0

findMultiples :: Foldable t => Int -> t Int -> [Int]
findMultiples n ns = [x | x <- [1..n], any (multipleOf x) ns]


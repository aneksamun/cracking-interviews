-- palindrome "aaaa"
-- True
-- palindrome [1,2,2,1]
-- True
-- palindrome "ab"
-- False

palindrome :: Eq a => [a] -> Bool
palindrome [] = True
palindrome[_] = True
palindrome (x:xs) = x == last xs && palindrome (init xs)

palindrome' xs = reverse xs == xs

palindrome'' xs = and $ zipWith (==) xs (reverse xs)


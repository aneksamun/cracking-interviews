import Data.List
import Data.Maybe

lastIndex :: Eq a => a -> [a] -> Maybe Int
lastIndex x xs = listToMaybe $ reverse $ elemIndices x xs

testAB :: [Char] -> Bool
testAB xs = a < b
  where
    a = fromMaybe (minBound :: Int) (lastIndex 'a' xs)
    b = fromMaybe (maxBound :: Int) (lastIndex 'b' xs)

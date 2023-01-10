import Data.Bits (Bits (xor))

findLonely :: (Foldable t, Bits b, Num b) => t b -> b
findLonely = foldl xor 0


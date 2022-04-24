-- Detects lonely number 
-- findLonelyNum [1, 1, 2, 2, 3]
-- 3

import Data.Bits

findLonelyNum :: (Foldable t, Bits b, Num b) => t b -> b
findLonelyNum = foldl xor 0

-- findLonelyNum ns = foldl xor 0 ns

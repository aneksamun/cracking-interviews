-- Counts total of '1' bit in the given number.
-- countPopulation 109
-- 5 (1101101)

countPopulation :: Integral a => a -> Int
countPopulation n = length $ filter (==1) $ map (`mod` 2) $ takeWhile (> 0) $ iterate (`div` 2) n


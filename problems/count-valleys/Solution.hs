
-- UDDDUDUU
-- /\
--   \     /
--    \/\/

counValleys :: (Foldable t, Num a) => t Char -> (a, a)
counValleys = foldl inspect (0, 0) where
    inspect (levels, valleys) 'U' = (levels + 1, valleys)
    inspect (levels, valleys) 'D' = (levels - 1, valleys)
    inspect stats _   = stats

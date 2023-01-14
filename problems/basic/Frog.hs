--         _  _
--        (.)(.)
--    ,-.(.____.),-.  
--   ( \ \ '--' / / )
--    \ \ / ,. \ / /
--     ) '| || |' ( 
-- OoO'- OoO''OoO -'OoO

import Data.Array

-- Count minimal number of jumps from position X to Y
countJumps :: (RealFrac a, Integral p) => a -> a -> a -> p
countJumps x y step = ceiling ((x - y) / step)

-- Find when frog can get to the other side

checkConditions x a = 
    let state = listArray (0, x) $ repeat False
    in foldl (\acc i -> acc // [(i, True)]) $ indices a


-- A = (1, 3, 1, 4, 2, 3, 5, 4) 
-- X = 5

-- 5


-- b = (false, true, true, true, true, false)



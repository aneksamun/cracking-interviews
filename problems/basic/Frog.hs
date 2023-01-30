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

earliestTime x a = 
    let positions = listArray (1, x) (repeat False)
    foldl test ([] x) (indices a)
        where
            test x y _ = 
                []

-- A = (1, 3, 1, 4, 2, 3, 5, 4) 
-- X = 5

-- 5




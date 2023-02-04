--         _  _
--        (.)(.)
--    ,-.(.____.),-.
--   ( \ \ '--' / / )
--    \ \ / ,. \ / /
--     ) '| || |' (
-- OoO'- OoO''OoO -'OoO

import Data.Array ( Ix, (!), (//), indices, listArray, Array )

-- Count minimal number of jumps from position X to Y
countJumps :: (RealFrac a, Integral p) => a -> a -> a -> p
countJumps x y step = ceiling ((x - y) / step)

-- Find when frog can get to the other side
earliestTime :: (Ix i, Num i) => i -> Array i i -> i
earliestTime x a =
  let leaves = listArray (0, x) (repeat False)
   in check leaves (indices a) x
  where
    check _ [] _ = -1
    check leaves (second : seconds) steps =
      let index = a ! second
       in if leaves ! index
            then check leaves seconds steps
            else case steps - 1 of
              0 -> second
              n -> check (leaves // [(index, True)]) seconds n


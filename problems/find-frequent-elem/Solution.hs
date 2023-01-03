{-# LANGUAGE TupleSections #-}

import qualified Data.Map as Map (fromListWith, foldlWithKey)
--import Data.Map (fromListWith, foldl)

-- mostFrequent :: (Ord k, Num a) => [k] -> Map k a
mostFrequent xs = Map.foldlWithKey 0 (\k v -> max v) $ Map.fromListWith (+) $ map (, 1) xs

--frequent = fst . findMax . fromListWith (+) . map (,1)
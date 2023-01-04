{-# LANGUAGE TupleSections #-}

import qualified Data.Map as Map (foldrWithKey, fromListWith)

mostFrequent :: [Integer] -> Integer
mostFrequent =
  fst
    . Map.foldrWithKey findWithMaxCount (-1, -1)
    . Map.fromListWith (+)
    . map (,1)
  where
    findWithMaxCount k v max = if v > snd max then (k, v) else max


module ExpirableMap where

import Control.Monad
import Data.Fixed (Pico)
import Data.Map (Map)
import qualified Data.Map as Map
import Data.Time
import Data.Time.Clock
import Distribution.Simple.Doctest (doctest)

mkUTCTime ::
  (Integer, Int, Int) ->
  (Int, Int, Pico) ->
  UTCTime
mkUTCTime (year, mon, day) (hour, min, sec) =
  UTCTime
    (fromGregorian year mon day)
    (timeOfDayToTime (TimeOfDay hour min sec))

-- Expirable data type

data Expirable a = Expirable {value :: a, validUntil :: UTCTime}
  deriving (Eq, Show)

isExpired :: Expirable a -> IO Bool
isExpired Expirable {validUntil = validUntil} = do
  now <- getCurrentTime
  return $ now `diffUTCTime` validUntil > 0

-- ExpirableMap data type

newtype ExpirableMap k v = ExpirableMap (Map k (Expirable v))
  deriving (Show)

empty :: ExpirableMap k v
empty = ExpirableMap Map.empty

fromList :: Ord k => [(k, Expirable v)] -> ExpirableMap k v
fromList = ExpirableMap . Map.fromList

insert :: Ord k => k -> Expirable v -> ExpirableMap k v -> ExpirableMap k v
insert k v (ExpirableMap m) = ExpirableMap $ Map.insert k v m

-- Main

main :: IO ()
-- main = do
--   let valid = Expirable {value = 1, validUntil = mkUTCTime (2023, 9, 1) (15, 13, 0)}
--    in isExpired valid >>= print

-- main = do
--   let expired = Expirable {value = 1, validUntil = mkUTCTime (2019, 9, 1) (15, 13, 0)}
--    in isExpired expired >>= print

-- main = do
--   now <- getCurrentTime
--   let a = Expirable {value = 1, validUntil = now}
--    in print $ fromList [("a", a)]

-- main = do
--   now <- getCurrentTime
--   let a = Expirable {value = 1, validUntil = now}
--       b = Expirable {value = 2, validUntil = now}
--       c = Expirable {value = 3, validUntil = now}
--    in print $ snd <$> [("a", a), ("b", b), ("c", c)]

main =
  do
    print $ filterM (\x -> if x then Just True else Just False) [True, False, True]

dot :: [a] -> [IO a]
dot xs = do
  return <$> xs

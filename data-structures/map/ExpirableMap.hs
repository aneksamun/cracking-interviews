module ExpirableMap where

import Control.Monad ()
import Control.Monad.Cont (MonadTrans (lift))
import Control.Monad.Trans.Maybe (MaybeT (MaybeT, runMaybeT))
import Data.Fixed (Pico)
import Data.Map (Map)
import qualified Data.Map as Map
import Data.Time
    ( fromGregorian,
      diffUTCTime,
      getCurrentTime,
      timeOfDayToTime,
      UTCTime(UTCTime),
      TimeOfDay(TimeOfDay) )
import Data.Time.Clock
    ( diffUTCTime, getCurrentTime, UTCTime(UTCTime) )

-- mkUTCTime

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

isExpiredAgainst :: UTCTime -> Expirable a -> Bool
isExpiredAgainst expiryTime Expirable {validUntil = validUntil} =
  expiryTime `diffUTCTime` validUntil > 0

-- ExpirableMap data type

newtype ExpirableMap k v = ExpirableMap (Map k (Expirable v))
  deriving (Show)

empty :: ExpirableMap k v
empty = ExpirableMap Map.empty

fromList :: Ord k => [(k, Expirable v)] -> ExpirableMap k v
fromList = ExpirableMap . Map.fromList

insert :: Ord k => k -> Expirable v -> ExpirableMap k v -> IO (ExpirableMap k v)
insert k v (ExpirableMap m) = do
  now <- getCurrentTime
  let unexpired = Map.filter (not . isExpiredAgainst now) m
  return $ ExpirableMap $ Map.insert k v unexpired

lookup :: Ord k => k -> ExpirableMap k v -> MaybeT IO (Expirable v)
lookup k (ExpirableMap m) = do
  now <- lift getCurrentTime
  let unexpired = Map.filter (not . isExpiredAgainst now) m
  MaybeT $ return $ Map.lookup k unexpired

-- Main

main :: IO ()
main = do
  let m = fromList [("a", Expirable 1 (mkUTCTime (2020, 1, 1) (0, 0, 0)))]
  m' <- insert "b" (Expirable 2 (mkUTCTime (2020, 1, 1) (0, 0, 0))) m
  print m'
  print =<< runMaybeT (ExpirableMap.lookup "a" m')
  print =<< runMaybeT (ExpirableMap.lookup "b" m')

  
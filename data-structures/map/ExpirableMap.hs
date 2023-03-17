module ExpirableMap where

import Control.Monad ()
import Control.Monad.Cont (MonadTrans (lift))
import Control.Monad.Trans.Maybe (MaybeT (MaybeT, runMaybeT))
import Data.Fixed (Pico)
import Data.Map (Map)
import qualified Data.Map as Map
import Data.Time
  ( TimeOfDay (TimeOfDay),
    UTCTime (UTCTime),
    addUTCTime,
    diffUTCTime,
    fromGregorian,
    getCurrentTime,
    timeOfDayToTime )
import Data.Time.Clock
  ( UTCTime (UTCTime),
    diffUTCTime,
    getCurrentTime )

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
  let notExpired = Map.filter (not . isExpiredAgainst now) m
  return $ ExpirableMap $ Map.insert k v notExpired

lookup :: Ord k => k -> ExpirableMap k v -> MaybeT IO (Expirable v)
lookup k (ExpirableMap m) = do
  now <- lift getCurrentTime
  MaybeT $ return $ Map.lookup k m >>= filterNotExpired now
  where
    filterNotExpired now value =
      if isExpiredAgainst now value
        then Nothing
        else Just value

size :: ExpirableMap k v -> Int
size (ExpirableMap m) = Map.size m

-- Main

main :: IO ()
main = do
  now <- getCurrentTime
  let teddy = Expirable {value = "Teddy", validUntil = mkUTCTime (2020, 1, 1) (0, 0, 0)}
      alice = Expirable {value = "Alice", validUntil = mkUTCTime (2021, 9, 1) (0, 0, 0)}
      james = Expirable {value = "James", validUntil = addUTCTime 100 now}
      group = fromList [("t", teddy)]
  print =<< runMaybeT (ExpirableMap.lookup "t" group)                                        -- Nothing as Teddy expired
  print . size =<< insert "a" alice group                                                    -- Removes Teddy and adds Alice
  insert "j" james group >>= \people -> runMaybeT (ExpirableMap.lookup "j" people) >>= print -- Prints James


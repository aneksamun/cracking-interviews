module ExpirableMap where

import Data.Map (Map)
import qualified Data.Map as Map

import Data.Time.Clock (UTCTime, getCurrentTime, diffUTCTime)
import Data.Time.Clock.Duration (Duration, toSeconds)

class Expirable a  where
  isExpired :: a -> Bool

-- newtype ExpirableMap k v = ExpirableMap (Map k v) deriving (Show)
newtype ExpirableMap k v = ExpirableMap (Map k v) deriving (Show)

fromList :: Ord k => [(k, v)] -> ExpirableMap k v
fromList = ExpirableMap . Map.fromList


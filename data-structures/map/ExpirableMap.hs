module ExpirableMap where

import Data.Map (Map)
import qualified Data.Map as Map
import Data.Time.Clock (UTCTime, diffUTCTime, getCurrentTime)

data Expirable a = Expirable
  { value :: a,
    validUntil :: UTCTime
  } deriving (Eq, Show)

-- newtype ExpirableMap k v = ExpirableMap (Map k v) deriving (Show)
newtype ExpirableMap k v = ExpirableMap (Map k (Expirable v)) deriving (Show)


fromList = ExpirableMap . Map.fromList

import Data.List (find)
import Data.Set (Set)
import qualified Data.Set as Set

minMissingElem :: [Int] -> Maybe Int
minMissingElem xs =
  let unique = Set.fromList xs
   in find (`Set.notMember` unique) [1 .. length xs]


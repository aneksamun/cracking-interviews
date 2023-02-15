import Data.Set (Set)
import qualified Data.Set as Set

isPerm :: [Int] -> Bool
isPerm xs =
  let unique = Set.fromList xs
   in length unique == length xs
        && all (`Set.member` unique) [1 .. length xs]


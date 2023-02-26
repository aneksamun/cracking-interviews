import Data.Char (isAsciiLower)

lowers :: String -> Int
lowers s = length [c | c <- s, isAsciiLower c]


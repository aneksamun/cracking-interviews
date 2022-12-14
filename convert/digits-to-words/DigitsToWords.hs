-- Converts digits to the words, for example, 1985 will be displayed as "one nine eight five".

import Data.Char (isSpace)

type Wording = [Char]

wordings :: [Wording]
wordings =  ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]

convert :: Int -> Wording
convert n
  | n == 0 = head wordings
  | otherwise =
    let s = match $ abs n
    in if n < 0 then "minus" ++ s else dropWhile isSpace s
  where
    match 0 = ""
    match x = match (x `div` 10) ++ " " ++ wordings !! (x `mod` 10)

import Data.Bifunctor
import Data.Map (Map, (!))
import qualified Data.Map as Map

-- roman

type RomanAndArabic = (String, Int)

numerals :: [RomanAndArabic]
numerals =
  [ ("M", 1000),
    ("CM", 900),
    ("D", 500),
    ("CD", 400),
    ("C", 100),
    ("XC", 90),
    ("L", 50),
    ("XL", 40),
    ("X", 10),
    ("IX", 9),
    ("V", 5),
    ("IV", 4),
    ("I", 1)
  ]

roman :: Int -> String
roman n
  | n <= 0 = undefined
  | otherwise = convert n 0
  where
    convert 0 _ = ""
    convert n i =
      let (numeral, value) = numerals !! i
       in if n >= value
            then numeral ++ convert (n - value) i
            else convert n (i + 1)

-- arabic

single :: Map Char Int
single = Map.fromList . map (first head) $ filter (\n -> (length . fst) n < 2) numerals

arabic :: String -> Int
arabic s = foldr convert 0 $ zip <*> tail $ s ++ "I" -- I is a dummy value
  where
    convert (roman1, roman2) acc =
      let a = single ! roman1
          b = single ! roman2
       in if a < b then acc - a else acc + a


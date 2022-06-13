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

roman :: Int -> [Char]
roman n
  | n <= 0 = "-"
  | otherwise = convert n 0
  where
    convert 0 _ = ""
    convert n i =
      let (numeral, value) = numerals !! i
       in if n >= value
            then numeral ++ convert (n - value) i
            else convert n (i + 1)


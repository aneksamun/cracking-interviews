luhnDouble :: Int -> Int
luhnDouble n = if doubled > 9 then doubled - 9 else doubled
  where
    doubled = n * 2

luhn4 :: Int -> Int -> Int -> Int -> Bool
luhn4 fst snd thrd frth = n `mod` 10 == 0
  where
    n = luhnDouble fst + snd + luhnDouble thrd + frth

luhn :: [Int] -> Bool
luhn digits = count digits `mod` 10 == 0
  where
    count = sum . zipWith ($) (cycle [id, luhnDouble]) . reverse 
    
luhn' :: [Char] -> Bool  
luhn' = luhn . map (\ch -> read [ch] :: Int)  


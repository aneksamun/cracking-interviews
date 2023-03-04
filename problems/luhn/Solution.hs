luhnDouble :: Int -> Int
luhnDouble n = if doubled > 9 then doubled - 9 else doubled
  where
    doubled = n * 2

luhn4 :: Int -> Int -> Int -> Int -> Bool
luhn4 fst snd thrd frth = n `mod` 10 == 0
  where
    n = luhnDouble fst + snd + luhnDouble thrd + frth

-- lunh s =
--     let
--         digits = map (\x -> read [x] :: Int) s
--         digits' = reverse digits
--         digits'' = zipWith (*) (cycle [1,2]) digits'
--         digits''' = map (\x -> if x > 9 then x - 9 else x) digits''
--     in
--         sum digits''' `mod` 10 == 0


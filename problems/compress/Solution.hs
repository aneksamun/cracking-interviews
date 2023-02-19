
compress :: String -> String
compress xs = encode 1 $ zip <*> tail $ xs ++ " "
  where
    encode _ [] = ""
    encode count ((curr, next) : xs)
        | curr == next = encode (count + 1) xs
        | otherwise = ([curr] ++ show count) ++ encode 1 xs


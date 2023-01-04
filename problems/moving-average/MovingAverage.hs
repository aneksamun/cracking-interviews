
calculate :: [Double] -> Int -> [Double]
calculate ns w =
    let size = length ns - w
    in [ sum (take w $ drop i ns) / fromIntegral w | i <- [0..size] ]


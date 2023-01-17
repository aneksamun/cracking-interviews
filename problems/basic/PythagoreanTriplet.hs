-- findTriplet 1000
-- (200,375,425)

findTriplet :: Integral c => c -> (c, c, c)
findTriplet n = head [ (a, b, c) | 
                     a <- [1..quot n 3],
                     b <- [a..quot n 2],
                     let c = n - a - b,
                     a ^ 2 + b ^ 2 == c ^ 2]

findTriplet' :: Integral c => c -> (c, c, c)
findTriplet' n = head [ (a, b, c) |
                     c <- [1 + quot n 3 .. quot n 2],
                     let sqa_b = c * c - n * n + 2 * n * c,
                     let a_b = floor(sqrt(fromIntegral sqa_b)),
                     let b = quot (n - c + a_b) 2,
                     let a = n - b - c,
                     a_b * a_b == sqa_b]


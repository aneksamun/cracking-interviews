-- findTriplet 1000
-- (200,375,425)

findTriplet :: Integer -> (Integer, Integer, Integer)
findTriplet n = head [(a, b, c) | 
                     a <- [1..quot n 3],
                     b <- [a..quot n 2],
                     let c = n - a - b,
                     a^2 + b^2 == c^2]


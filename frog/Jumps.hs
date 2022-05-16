-- Counts minimal number of jumps from position X to Y.
-- (x = 10, y = 85, d = 30) => 85 - 10 / 30

calcJumps :: (RealFrac a, Integral p) => a -> a -> a -> p
calcJumps x y step = ceiling ((x - y) / step)


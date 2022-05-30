-- Counts minimal number of jumps from position X to Y.
-- (x = 10, y = 85, d = 30) => 85 - 10 / 30

calculateJumps :: (RealFrac a, Integral p) => a -> a -> a -> p
calculateJumps x y step = ceiling ((x - y) / step)



calculateJumps :: (RealFrac a, Integral p) => a -> a -> a -> p
calculateJumps x y step = ceiling ((x - y) / step)


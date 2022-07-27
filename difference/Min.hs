

minDiff :: Num a => [a] -> [a]
minDiff [] = []
minDiff (n:ns) = n - sum ns : minDiff ns


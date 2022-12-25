
counValleys :: (Foldable t, Eq a, Num a, Num a) => t Char -> a
counValleys = snd . foldl count (0, 0)
  where
    count (levels, valleys) 'U' =
      case levels + 1 of
        0 -> (0, valleys + 1)
        n -> (n, valleys)
    count (levels, valleys) 'D' =
      (levels - 1, valleys)
    count stats _ = stats


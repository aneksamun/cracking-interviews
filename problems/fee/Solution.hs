import Data.List

fee = 5
feeOverYear = 12 * fee

calculate :: (Ord a1, Eq a2, Fractional a1) => [a1] -> [[a2]] -> a1
calculate amounts dates =
  let discount = fee * length (filter feeFreeMonths . groupBy month $ zip amounts dates)
      amount = sum amounts
      percentage = fromIntegral (feeOverYear - discount) / 100
   in percentage * amount
  where
    month (_, d1) (_, d2) =
      let (x : xs) = take 7 <$> [d1, d2]
       in x == head xs
    feeFreeMonths = (<= -100) . sum . filter (< 0) . map fst


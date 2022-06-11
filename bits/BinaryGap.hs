import Data.Bits
import Data.Word

ushiftR :: Int -> Int -> Int
ushiftR n t = fromIntegral (fromIntegral n `shiftR` t :: Word)

findLongestBinaryGap n = detect n 0 0 False
  where
    detect n longestGap currentGap gapRevealed
      | n == 0 = longestGap
      | otherwise = if (.&.) n 1 == 0
        then if gapRevealed
          then detect (ushiftR n 1) longestGap 0 False
          else detect (ushiftR n 1) longestGap (currentGap + 1) True
        else detect (ushiftR n 1) longestGap 0 gapRevealed

-- setEvenBit :: (Bits a, Num a, Num p) => a -> p
-- setEvenBit n = if (.&.) n 1 == 1 then 1 else 0

-- splitWhen :: (a -> Bool) -> [a] -> [[a]]
-- splitWhen _ [] = []
-- splitWhen p xs = let (ys, zs) = span p xs
--                  in ys : splitWhen p (drop 1 zs)

-- gaps :: Int -> [Int]
-- gaps n = map setEvenBit $ takeWhile (> 0) $ iterate (`ushiftR` 1) n



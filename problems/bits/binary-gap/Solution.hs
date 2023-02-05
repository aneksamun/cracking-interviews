import Data.Bits ( Bits((.&.), shiftR) )
import Data.Word ()

ushiftR :: Int -> Int -> Int
ushiftR n t = fromIntegral (fromIntegral n `shiftR` t :: Word)

longestGap :: Int -> Int
longestGap = findGap 0 0 False . takeWhile (> 0) . iterate (`ushiftR` 1)
  where
    findGap longest _ _ [] = longest
    findGap longest current gapRevealed (n : ns) =
      if (.&.) n 1 == 0
        then findGap longest (if gapRevealed then current + 1 else current) gapRevealed ns
        else findGap (max longest current) 0 True ns


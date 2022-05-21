import Data.Bits
import Data.Word

ushiftR :: Int -> Int -> Int
ushiftR n t = fromIntegral (fromIntegral n `shiftR` t :: Word)

setEvenBit :: (Bits a, Num a, Num p) => a -> p
setEvenBit n = if (.&.) n 1 == 1 then 1 else 0

gaps :: Int -> [Int]
gaps n = map setEvenBit $ takeWhile (> 0) $ iterate (`ushiftR` 1) n

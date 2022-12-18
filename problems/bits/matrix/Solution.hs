-- range: [128, 64, 32, 16, 8, 4, 2, 1]

import Control.Monad
import Data.Bits

identifyBit :: (Bits a, Num a) => a -> a -> Char
identifyBit x y = if (.&.) x y == 0 then '0' else '1'

range :: [Integer]
range = takeWhile (> 0) $ iterate (`div` 2) 128

left2Right :: IO ()
left2Right = forM_ a $ \i -> do putStrLn $ map (identifyBit i) b
  where
    b = range
    a = reverse b

right2Left :: IO ()
right2Left = forM_ nums $ \i -> do putStrLn $ map (identifyBit i) nums
  where nums = range

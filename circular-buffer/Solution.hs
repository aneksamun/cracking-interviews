import Data.IORef

getNumber :: IO Int
getNumber = do
  line <- getLine
  return (read line :: Int)

main :: IO ()
main = do
  putStr "Enter buffer size: "
  size <- getNumber
  putStr "Enter record count: "
  count <- getNumber
  let records = [0..count]
  buffer <- newIORef []
  return ()


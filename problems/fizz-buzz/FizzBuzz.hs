numbers :: [Integer]
numbers = map (+ 1) [0 ..]

fizzes :: [String]
fizzes = cycle [[], [], "Fizz"]

buzzes :: [String]
buzzes = cycle [[], [], [], [], "Buzz"]

fizzBuzzes :: [String]
fizzBuzzes = zipWith3 fizzBuzz numbers fizzes buzzes
  where
    fizzBuzz n [] [] = show n
    fizzBuzz _ fizz buzz = fizz ++ buzz

-- take 15 fizzBuzzes
-- ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

-- fizzBuzzes !! 1004
-- "FizzBuzz"


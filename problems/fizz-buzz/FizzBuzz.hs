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


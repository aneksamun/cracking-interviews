{-# LANGUAGE GADTs #-}

import Control.Arrow (left)
import Text.Read (readEither)

-- Errors

data InterpretationError = UnsupportedOperand String | StackEmpty

instance Show InterpretationError where
  show (UnsupportedOperand op) = "Unsupported operand: " ++ op
  show StackEmpty = "Not enough operands"

-- Stack

data Stack a where
  Stack :: [a] -> Stack a
  deriving (Show)

empty :: Stack a
empty = Stack []

push :: a -> Stack a -> Stack a
push x (Stack xs) = Stack (x : xs)

pop :: Stack a -> Either InterpretationError (a, Stack a)
pop (Stack []) = Left StackEmpty
pop (Stack (x : xs)) = Right (x, Stack xs)

-- Interpretation

interpret :: String -> Either InterpretationError Int
interpret s = fmap fst $ foldl apply (Right empty) (words s) >>= pop
  where
    apply stack "+" = stack >>= pop >>= \(x, xs) -> pop xs >>= \(y, xs') -> Right (push (x + y) xs')
    apply stack "-" = stack >>= pop >>= \(x, xs) -> pop xs >>= \(y, xs') -> Right (push (x - y) xs')
    apply stack "POP" = stack >>= pop >>= \(_, stack) -> Right stack
    apply stack "DUP" = stack >>= pop >>= \(n, stack) -> Right (push n $ push n stack)
    apply stack n = do
      xs <- stack
      x <- left (\_ -> UnsupportedOperand n) (readEither n :: Either String Int)
      Right (push x xs)


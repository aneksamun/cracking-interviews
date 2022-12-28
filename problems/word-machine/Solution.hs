{-# LANGUAGE GADTs #-}

import Data.Maybe ()

data Stack a where
  Stack :: [a] -> Stack a
  deriving (Show)

empty :: Stack a
empty = Stack []

push :: a -> Stack a -> Stack a
push x (Stack xs) = Stack (x : xs)

pop :: Stack a -> Maybe (a, Stack a)
pop (Stack []) = Nothing
pop (Stack (x : xs)) = Just (x, Stack xs)

interpret :: String -> Maybe Int
interpret s = fmap fst $ foldl apply (Just empty) (words s) >>= pop
  where
    apply :: Maybe (Stack Int) -> String -> Maybe (Stack Int)
    apply maybeStack "+" = maybeStack >>= pop >>= \(x, xs) -> pop xs >>= \(y, xs') -> Just (push (x + y) xs')
    apply maybeStack "-" = maybeStack >>= pop >>= \(x, xs) -> pop xs >>= \(y, xs') -> Just (push (x - y) xs')
    apply maybeStack "POP" = maybeStack >>= pop >>= \(_, stack) -> Just stack
    apply maybeStack "DUP" = maybeStack >>= pop >>= \(n, stack) -> Just (push n $ push n stack)
    apply maybeStack n = fmap (push (read n)) maybeStack

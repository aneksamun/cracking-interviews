### <ins>Fibonacci</ins>

Fibonacci is a sequence of numbers where each number is the sum of the two preceding ones, starting from 0 and 1. That is the sequence of 1 1 2 3 5 8 13 21 34 55 ...

- [Clojure solution](fibonacci.clj) usage example:
```clojure
clj:user:> (take 10 fibonacci-iter)
(0 1 1 2 3 5 8 13 21 34)

clj:user:> (nth fibonacci-iter 9)
34
```
- [Haskell solution](Fibonacci.hs) usage example:
```haskell
*Main> take 7 fibonacci 
[1,1,2,3,5,8,13]

*Main> fibonacci !! 6
13
```

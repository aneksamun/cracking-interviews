### <ins>Sum multiples</ins>

Euler problem #1.   

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

- [Clojure solution](solution.clj) usage example:
```clojure
clj:user:> (find-multiples 999 [3 5])  
(3 5 6 9 10 12 15 18 20 21 24 25 .. 999)

clj:user:> (sum-multiples 999 [3 5])  
233168
```
- [Haskell solution](Solution.hs) usage example:
```haskell
*Main> findMultiples 999 [3, 5]
[3,5,6,9,10,12,15,18,20,21,24,25..999]

*Main> sumMultiples 999 [3, 5]
233168
```

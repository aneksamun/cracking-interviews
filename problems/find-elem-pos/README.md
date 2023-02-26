### <ins>Find all positions of the element</ins>

Find all positions of the element in the list.

- [Clojure solution](solution.clj) usage example:
```clojure
clj:user:> (find true [true false true])
(0 2)
```
- [Haskell solution](Solution.hs) usage example:
```haskell
*Main> find False [True, False, True, False]
[1,3]

*Main> findTupled 'b' [('a', 1), ('b', 2), ('c', 3), ('b', 4)]
[2,4]
```

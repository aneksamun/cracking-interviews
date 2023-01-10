### <ins>Find all positions of the element</ins>

Find all occurring positions for given item within the list of items. Example:

|Input                      | Item  | Postions |
|---------------------------|-------|----------|
|[True, False, True, False] | False | [1,3]    |

- [Clojure solution](solution.clj) usage example:
```clojure
clj:user:> (positions true [true false true])
(0 2)
```
- [Haskell solution](Solution.hs) usage example:
```haskell
*Main> positions False [True, False, True, False]
[1,3]
```

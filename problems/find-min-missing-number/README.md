### <ins>Find Minimal Missing Element</ins>

Find the minimal positive integer not occurring in a given sequence.

#### Solution

```scala
def findMinPos(array: Array[Int]): Int = {
  val unique = array.filter(_ > 0).toSet
  (1 to array.length + 1).filterNot(unique.contains).head
}
```

#### Examples

- [Haskell solution](Solution.hs) usage example:
```haskell
*Main Data.Maybe> minMissingElem [1, 3, 6, 4, 1, 2]
Just 5

*Main> minMissingElem [-1 -3]
Just 1

*Main> minMissingElem [1, 2]
Nothing
```
- [Clojure solution](solution.clj) usage example:
```clojure
clj:user:> (user/min-missing-elem [1 3 6 4 1 2])
5

clj:user:> (user/min-missing-elem [-1 -3])
1

clj:user:> (user/min-missing-elem [1 2])
nil
```

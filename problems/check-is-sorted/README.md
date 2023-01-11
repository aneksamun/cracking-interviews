### <ins>Check collection is sorted</ins>

Given a collection of elements, check whether the collection is sorted.   
Examples:
```
[1, 2, 3, 4] -> true
[1, 2, 4, 3] -> false
```
Algorithm:
```c++
bool isSorted = true;
for (int i = 0; i < n - 1; i++) {
    if (a[i] > a[i + 1]) {
        isSorted = false;
        break;
    }
}
return isSorted;
```

[Clojure solution](Solution.clj) usage example:
```clojure
clj:user:> (is-sorted? [1 2 3 4])
true
```

[Haskell solution](Solution.hs) usage example:
```haskell
*Main> isSorted [1, 2, 3, 4]
True

*Main> pairs [1, 2, 3, 4]
[(1,2),(2,3),(3,4)]
```

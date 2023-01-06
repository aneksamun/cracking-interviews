### <ins>Lonely Number</ins>

Finds unique element. Example:
```
[9, 3, 9, 3, 9, 7, 9] -> 7
[1, 1, 2, 2, 3] -> 3
```

Solution maybe using XOR operation.
```scala
def findUnique(array: Iterable[Int]): Int = 
  array.reduceLeft((prev, curr) => prev ^ curr)  
```

### <ins>Pascal Triangle</ins>

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle. For example, for numRows = 11, the output should be:
```

               1
              1 1
             1 2 1
            1 3 3 1
           1 4 6 4 1
         1 5 10 10 5 1
        1 6 15 20 15 6 1
       1 7 21 35 35 21 7 1
      1 8 28 56 70 56 28 8 1
    1 9 36 84 126 126 84 36 9 1
1 10 45 120 210 252 210 120 45 10 1
```
- [C++ solution](pascal_triangle.cpp) usage example:
```c++
Enter the number of rows: 6
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
```
- [Clojure solution](pascal_triangle.clj) usage example:
```clojure
clj:user:> (take 7 triangle)
([1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1] [1 5 10 10 5 1] [1 6 15 20 15 6 1])

clj:user:> (nth triangle 10)
[1 10 45 120 210 252 210 120 45 10 1]
```
- [Haskell solution](PascalTriangle.hs) usage example:
```haskell
*Main> pascalTriangle 7
[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1],[1,6,15,20,15,6,1]]

*Main> take 7 triangle
[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1],[1,6,15,20,15,6,1]]

*Main> triangle !! 7
[1,7,21,35,35,21,7,1]
```

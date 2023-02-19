### <ins>Compress</ins>

Encode a string by replacing each run of identical characters with a single character followed by a count of consecutive appearances of that character.   
For example "aartta" should be encoded as "a2r1t2a1".

- [Haskell solution](Solution.hs) usage example:
```haskell
*Main> compress "aaardvark"
"a3r1d1v1a1r1k1"
```
- [C++ solution](solution.cpp) usage example:
```bash
%› » ./compress "aaardvark"
a3r1d1v1a1r1k1
```
- [Clojure solution](solution.clj) usage example:
```clojure
clj:user:> (user/compress "aaardvark")
"a3r1d1v1a1r1k1"
```

### <ins>Fizz Buzz</ins>

Print integers from one to N, print “Fizz” if an integer is divisible by three, “Buzz” if an integer is divisible by five, and “FizzBuzz” if an integer is divisible by both three and five.   
Basic implementation:
```c++
 for (int i = 1; i <= n; i++) {
    if (i % 3 == 0 && i % 5 == 0) 
        cout << "FizzBuzz" << endl;
    else if (i % 3 == 0)
        cout << "Fizz" << endl;
    else if (i % 5 == 0)
        cout << "Buzz" << endl;
    else cout << i << endl;
}
```
Alternatively, can use a counter for each number and reset it when it reaches 3 or 5. This is a bit more efficient than the above solution.
```c++
for (int i = 1, c3 = 0, c5 = 0; i <= n; i++, c3++, c5++) {
    if (c3 == 3) {
        cout << "Fizz";
        c3 = 0;
    }
    if (c5 == 5) {
        cout << "Buzz";
        c5 = 0;
    }
}
```
It clearly shows the pattern which is been used in [Clojure solution](fizz-buzz.clj) and [Haskell solution](FizzBuzz.hs).


- [Clojure solution](fizz_buzz.clj) usage example:
```clojure
clj:user:> (take 30 (map fizzbuzz numbers fizzes buzzes))
(1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz)

clj:user:> (nth (map fizzbuzz numbers fizzes buzzes) 1004)
"FizzBuzz"
```
- [Haskell solution](FizzBuzz.hs) usage example:
```haskell
*Main> take 15 fizzBuzzes
["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

*Main> fizzBuzzes !! 1004
"FizzBuzz"
```

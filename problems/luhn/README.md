### <ins>Luhn algorithm</ins>

The Luhn algorithm is used to check bank card numbers for simple errors such as mistyping a digit, and proceeds as follows:
- consider each digit as a separate number;
- moving left, double the value of every second digit;
- if the result of this doubling operation is greater than 9 (e.g., 8 × 2 = 16), then sum the digits of the products (e.g., 16: 1 + 6 = 7, 18: 1 + 8 = 9) to get a single digit number (or just subtract 9 from it);
- add all these digits together;
- if the total ends in 0 (put another way, if the total modulus 10 is congruent to 0), then the number is valid according to the Luhn formula, else it is not valid.

[Haskell solution](Solution.hs) usage example:
```haskell
*Main> luhn4 1 7 8 4
True
*Main> luhn4 4 7 8 3
False

*Main> luhn [1, 7, 8, 4]
True
*Main> luhn [4, 7, 8, 3]
False

*Main> luhn' "79927398713"
True
```
[C++ solution](solution.cpp) usage example:
```bash
% » ./luhn "79927398713"
true
% » ./luhn "1784"       
true
% » ./luhn "4783"
false
```

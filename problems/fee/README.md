### <ins>Calculate Fee</ins>

Given a list of transactions, which consist of the amounts and dates, calculate the fee over the months. The fee is 5% of the total amount over the month, but not more than 100. The fee is applied on the first day of the month
If the total amount over the month is less or equal to -100 then no fee should be applied for that month.

```haskell
*Main> calculate [100, 100, 100, -10] ["2020-12-31", "2020-12-22", "2020-12-22", "2020-12-29"]
174.0
*Main> calculate [180, -50, -25, -25] ["2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"]
44.0
*Main> calculate [1, -1, 0, -105,  1] ["2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"]
-57.2
```

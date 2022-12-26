(ns fizz-buzz)

(def numbers (map inc (range)))                      ; sequence of 1 2 3 4 5 6 7 8 9 10 etc.
(def fizzes (cycle [nil nil "Fizz"]))                ; sequence of nil nil fizz nil nil fizz etc.
(def buzzes (cycle [nil nil nil nil "Buzz"]))        ; sequence of nil nil nil nil buzz nil nil nil nil buzz etc.

(defn fizzbuzz [n fizz buzz]
  (if (or fizz buzz)                                 ; if not nil
    (str fizz buzz)                                  ; concatenate both, nil is treated as an empty string
    (str n)))                                        ; otherwise return string as it is

(take 30 (map fizzbuzz numbers fizzes buzzes))
;; => (1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz)

(nth (map fizzbuzz numbers fizzes buzzes) 1004)
;; => "FizzBuzz"


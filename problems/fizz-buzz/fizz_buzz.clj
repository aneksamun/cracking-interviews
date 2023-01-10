(ns fizz-buzz)

(def numbers (map inc (range)))                      ; sequence of 1 2 3 4 5 6 7 8 9 10 etc.
(def fizzes (cycle [nil nil "Fizz"]))                ; sequence of nil nil fizz nil nil fizz etc.
(def buzzes (cycle [nil nil nil nil "Buzz"]))        ; sequence of nil nil nil nil buzz nil nil nil nil buzz etc.

(defn fizzbuzz [n fizz buzz]
  (if (or fizz buzz)                                 ; if not nil
    (str fizz buzz)                                  ; concatenate both, nil is treated as an empty string
    (str n)))                                        ; otherwise return string as it is


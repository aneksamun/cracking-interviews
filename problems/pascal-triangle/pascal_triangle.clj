(ns pascal-triangle)

(comment "
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1")

(comment "
The next row can be generated by duplicating the previous row,
shifting one of them to the left or right,
and then summing the offset digits, i.e.
  1  4  6  4  1  0
+ 0  1  4  6  4  1
= 1  5 10 10  5  1")

(defn next-row [previous]
  (apply vector (map + (conj previous 0)
                       (cons 0 previous))))

(def triangle (iterate next-row [1]))

(take 7 triangle)
;; => ([1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1] [1 5 10 10 5 1] [1 6 15 20 15 6 1])

(nth triangle 10)
;; => [1 10 45 120 210 252 210 120 45 10 1]


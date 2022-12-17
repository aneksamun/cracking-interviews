;; (find-multiples 999 [3 5])  
;; (3 5 6 9 10 12 15 18 20 21 24 25 .. 999)

;; (sum-multiples 999 [3 5])  
;; 233168

(defn find-multiples [n xs]
  (filter (fn [x] (some #(== (mod x %) 0) xs)) (range 1 (inc n))))

(defn sum-multiples [n xs]
  (reduce + (find-multiples n xs)))


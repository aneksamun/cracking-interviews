
(defn find-multiples [n xs]
  (filter (fn [x] (some #(== (mod x %) 0) xs)) (range 1 (inc n))))

(defn sum-multiples [n xs]
  (reduce + (find-multiples n xs)))


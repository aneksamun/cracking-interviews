
;; (defn find-multiples [n xs]
;;     (filter (fn [x] (some-fn #(mod x %) xs)) (range (inc n))))

(defn find-multiples [n xs]
    (filter (fn [x] 
        (some-fn (fn [y] (== (mod x y) 0)) xs)) (range (inc n))))
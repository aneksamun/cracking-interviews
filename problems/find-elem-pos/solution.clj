;; (positions true [true false true])
;; (0 2)

(defn positions [x xs]
  (->> xs
       (map-indexed vector)
       (filter (fn [[_ x']] (= x' x))) 
       (map first)))

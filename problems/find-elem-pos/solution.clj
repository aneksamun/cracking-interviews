
(defn positions [x xs]
  (->> xs
       (map-indexed vector)
       (filter (fn [[_ x']] (= x' x))) 
       (map first)))


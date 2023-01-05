
(defn most-frequent [xs]
  (first (last (sort-by val (frequencies xs)))))

(defn most-frequent' [xs]
  (->> xs
       frequencies
       (sort-by val)
       last
       first))

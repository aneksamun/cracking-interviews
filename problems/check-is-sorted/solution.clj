
(defn is-sorted [xs]
  (every? (fn [[a b]] (< a b))
          (zipmap xs (rest xs))))

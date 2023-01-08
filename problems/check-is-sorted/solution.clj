
(defn is-sorted [xs]
  (let [pairs (zipmap xs (rest xs))]
    (every? (fn [[a b]] (<= a b)) pairs)))


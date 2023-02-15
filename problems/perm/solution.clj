
(defn is-perm [xs]
  (let [unique (set xs)]
    (and (= (count xs) (count unique))
         (every? #(contains? unique %) (range 1 (inc (count xs)))))))


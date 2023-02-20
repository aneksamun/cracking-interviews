
(defn min-missing-elem [xs]
  (let [unique (set xs)]
    (first (filter #(not (contains? unique %)) (range 1 (inc (count xs)))))))


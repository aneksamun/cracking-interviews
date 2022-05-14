
(defn count-population [n]
  (take-while (partial > 0) (iterate (partial / 2) n)))

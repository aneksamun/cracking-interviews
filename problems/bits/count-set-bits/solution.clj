;; (count-population 109)
;; 5

(defn count-population [n]
  (count
   (filter (fn [x] (= x 1))
           (map (fn [x] (mod x 2))
                (take-while #(> %1 0) (iterate #(unchecked-divide-int %1 2) n))))))


(defn luhn-double [n]
  (let [doubled (* 2 n)]
    (if (> doubled 9) (- doubled 9) doubled)))

(defn luhn [digits]
  (== 0 (mod (reduce + (map #(%1 %2) (cycle [identity luhn-double]) (reverse digits))) 10)))

(defn luhn' [s]
  (luhn (map #(Character/getNumericValue %) s)))


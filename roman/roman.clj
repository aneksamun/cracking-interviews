(ns roman)

(def numerals [["M" 1000]
               ["CM" 900]
               ["D" 500]
               ["CD" 400]
               ["C" 100]
               ["XC" 90]
               ["L" 50]
               ["XL" 40]
               ["X" 10]
               ["IX" 9]
               ["V" 5]
               ["IV" 4]
               ["I" 1]])

(defn convert-recursive
  ([number]
   (convert-recursive number 0 ""))
  ([remainder numeral-index roman]
   (if (zero? remainder)
     roman
     (let [[symbol value] (nth numerals numeral-index)]
       (if (>= remainder value)
         (convert-recursive (- remainder value) numeral-index (str roman symbol))
         (convert-recursive remainder (inc numeral-index) roman))))))

(defn convert [number]
  "Simulates tail recursion by optimizing it into loop"
  (loop [remainder number, numeral-index 0, roman ""]
    (if (zero? remainder)
      roman
      (let [[symbol value] (nth numerals numeral-index)]
        (if (>= remainder value)
          (recur (- remainder value) numeral-index (str roman symbol))
          (recur remainder (inc numeral-index) roman))))))

;; (roman/convert-recursive 900)
;; (roman/convert 909)

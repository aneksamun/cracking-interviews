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

(defn convert-to-roman-recursive
  ([number]
   (convert-to-roman-recursive number 0 ""))
  ([remainder numeral-index roman]
   (if (zero? remainder)
     roman
     (let [[symbol value] (nth numerals numeral-index)]
       (if (>= remainder value)
         (convert-to-roman-recursive (- remainder value) numeral-index (str roman symbol))
         (convert-to-roman-recursive remainder (inc numeral-index) roman))))))

(defn convert-to-roman
  "Simulates tail recursion by optimizing it into loop"
  [number]
  (loop [remainder number, numeral-index 0, roman ""]
    (if (zero? remainder)
      roman
      (let [[symbol value] (nth numerals numeral-index)]
        (if (>= remainder value)
          (recur (- remainder value) numeral-index (str roman symbol))
          (recur remainder (inc numeral-index) roman))))))

(defn convert-to-arabic [s]
  (let [nums (apply vector s)
        tail (conj (apply vector (rest nums)) \I)
        single (->> numerals
                    (filter (fn [[fst _]] (< (count fst) 2)))
                    (map (fn [[fst snd]] [(first fst) snd]))
                    (reduce conj {}))
        pairs (apply vector (map vector nums tail))]
    (reduce (fn [acc [fst snd]]
              (let [current (get single fst)
                    next (get single snd)]
                (if (< current next)
                  (- acc current)
                  (+ acc current)))) 0 pairs)))


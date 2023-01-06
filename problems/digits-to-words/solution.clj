(ns digits2words
  (:require [clojure.string :refer [join]]))

(def wordings ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"])

(defn convert [n] 
  (cond 
    (= n 0) (nth wordings 0)
    :else 
      (loop [i (Math/abs n) acc ()]
        (if (< i 1) 
          (str (when (< n 0) "minus ") (join " " acc))
          (recur (/ i 10) (conj acc (nth wordings (mod i 10))))))))


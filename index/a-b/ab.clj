(ns positions
    (:require [clojure.string :refer [last-index-of]]))

(defn compare-ab-pos [s]
  (let [a (or (last-index-of s "a") Integer/MIN_VALUE)
        b (or (last-index-of s "b") Integer/MAX_VALUE)]
        (< a b)))

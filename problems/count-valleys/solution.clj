
(defn count-valleys [s]
  (loop [letters s levels 0 valleys 0]
    (let [curr (first letters)
          remaining (rest letters)]
      (cond
        (= curr \U) (let [levels' (+ levels 1)
                          valleys' (if (= levels' 0) (+ valleys 1) valleys)]
                      (recur remaining levels' valleys'))
        (= curr \D) (recur remaining (- levels 1) valleys)
        (empty? remaining) valleys
        :else (recur remaining levels valleys)))))


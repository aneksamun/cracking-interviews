
(defn compress [s]
  (let [source (str s " ")
        pairs (map vector source (rest source))]
    (loop [pairs pairs count 1 acc ""]
      (let [[fst snd] (first pairs) 
            tail (rest pairs)]
        (cond (empty? tail) (str acc fst count)
              (= fst snd) (recur tail (inc count) acc)
              :else (recur tail 1 (str acc fst count)))))))


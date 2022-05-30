;; (calculate [1 2 3 4] 2)
;; 1.5 2.5 3.5 nil
;;
;; (calculate [1 2 3 4] 4)
;; 2.5 nil

(defn slice [ns begin end]
  (subvec ns begin (+ begin end)))

(defn calc-sub-avg [ns i window]
  (let [sublist (slice ns i window)
        sum (reduce + sublist)
        len (count sublist)]
    (/ sum (double len))))

(defn calculate [ns window]
  (let [len (inc (- (count ns) window))
        arr (make-array Double/TYPE len)]
    (dotimes [i len]
      (do
        (aset-double arr i (calc-sub-avg ns i window))
        (print (str (aget arr i) " : "))))))

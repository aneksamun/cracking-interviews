;;
;; (load-file "factorial.clj")
;; (factorial 5)
;;

(defn factorial [n]
  (reduce * (range 1 (inc n))))

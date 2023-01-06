
(def fibonacci-seq
  ((fn iter [a b] 
     (lazy-seq (cons a (iter b (+ a b))))) 0 1))

(def fibonacci-seq'
  (lazy-cat [0 1] (map + (rest fibonacci-seq') fibonacci-seq')))

(def fibonacci-iter
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

;; (take 10 fibonacci-iter)
;; (nth fibonacci-iter 10)


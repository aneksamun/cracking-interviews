(ns mars-rover)

(def rotations
  {:north {:left :west, :right :east}
   :east  {:left :north, :right :south}
   :south {:left :east, ::right :west}
   :west  {:left :south, :right :north}})

(def translations
  {:north {:delta-x 0, :delta-y 1}
   :east  {:delta-x 1, :delta-y 0}
   :south {:delta-x 0, :delta-y -1}
   :west  {:delta-x -1, :delta-y 0}})

(defn robot [coordinates bearing]
  (hash-map :coordinates coordinates, :bearing bearing))

(defn turn-right [robot]
  (let [bearing (:bearing robot)]
    (assoc robot :bearing (-> rotations bearing :right))))

(defn turn-left [robot]
  (let [bearing (:bearing robot)]
    (assoc robot :bearing (-> rotations bearing :left))))

(defn move-ahead [robot]
  (let [{{x :x, y :y} :coordinates, bearing :bearing} robot]
    (let [{delta-x :delta-x, delta-y :delta-y} (translations bearing)]
      (assoc robot :coordinates {:x (+ x delta-x), :y (+ y delta-y)}))))

(defn do-step [robot next-step]
  (case next-step
    \A (move-ahead robot)
    \L (turn-left robot)
    \R (turn-right robot)))

(defn simulate [steps initial-robot]
  (reduce do-step initial-robot steps))


;; (robot {:x -2 :y 1} :east)
;; => {:coordinates {:x -2, :y 1}, :bearing :east}

;; (:right (:east rotations))
;; (-> rotations :east :right)
;; => :south

;; (turn-left (robot {:x 0 :y 0} :north))
;; => {:coordinates {:x 0, :y 0}, :bearing :west}
;; (turn-right (robot {:x 0 :y 0} :north))
;; => {:coordinates {:x 0, :y 0}, :bearing :east}
;; (move-ahead (robot {:x 0 :y 0} :north))
;; => {:coordinates {:x 0, :y 1}, :bearing :north}

;; (simulate "AALR" (robot {:x 0 :y 0} :north))
;; => {:coordinates {:x 0, :y 2}, :bearing :north}

(ns wonderland.favfoods)


(defn grow [name direction]
  (if (= direction :small)
  (str name " is growing smaller")
  (str name " is growing bigger")))
;; can use the function with partial to only use one arguement, the technique is called currying.

(defn toggle-grow [direction]
  (if (= direction :small) :big :small))

(defn oh-my [direction]
  (str "oh my! you are growing " direction))

(defn surprise [direction]
  ((comp oh-my toggle-grow) direction))


;; using comp can combine functions and pass the argument to the functions

(defn adder [x y]
  (+ x y))


(let [[colour size] ["blue" "small"]]
(str "the " colour " door is " size))


;; this is the same as above but more verbose
(let [x ["blue" "small"]
  colour (first x)
  size (last x)]
  (str "The " colour "door is " size))

(let [[colour [size sized]] ["blue" ["very small" "very large" "massive"]]]
  (str "The " colour "door is " size sized))
;; by adding an ampersand to the sized parameter you can call the rest of the vector.

(let [[colour [size] :as original] ["blue" ["very small" "very large" "massive"]]]
  (str "The " colour "door is " size)
  {:colour colour :size size :orginal original})

;; destructuring can be done with maps tools

(let [{flower1 :flower1 flower2 :flower2}
  {:flower1 "red" :flower2 "blue"}]
  (str "The flowers are " flower1 " and " flower2))


(let [{flower1 :flower1 flower2 :flower2 :or {flower2 "missing"}}
  {:flower1 "red" }]
  (str "The flowers are " flower1 " and " flower2))
;;the above uses :or to specify  default value if there is no flower2
; can use add too to keep the whole initial data structue

(let [{flower1 :flower1 :as all-flower}
  {:flower1 "red"}]
  [flower1 all-flower])


(let [{:keys [flower1 flower2]}{:flower1 "blue" :flower2 "green"}] (str flower1 flower2))

(defn flower-colours [colours]
  (str (:flower1 colours)
  (:flower2 colours)
  ))

;;(wonderland.favfoods/flower-colours {:flower1 "red" :flower2 "green"})
;calling the function with this format works however it is not as clear as the destructuring method below.

(defn flower-colours [{:keys [flower1 flower2]}]
(str flower1 " " flower2))


;clojure can work with infinite lists
;if you do not specify a range with (range) you have an infinite list
;calling range returns a lazy sequences

;repeat can be used to generate a lazy sequence

(take 500(repeat "harry"))

(rand-int 10)
;produces a random integer between 1 and 10

(take 10(repeatedly #(rand-int 10)))

;use repeatedly which takes a function to get a random list.

;another way to generate lazy sequences is with cycle- it takes a collection as and arg and returns a lazy seq of the items in the collection repeated infinitely
(take 10 (cycle ["john and michele" "ian and stace"]))

; we can interact with all other clojure sequence functions.

(take 10 (rest (cycle ["john and michele" "ian and stace"])))

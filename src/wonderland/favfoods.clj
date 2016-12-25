(ns wonderland.favfoods)


(defn grow [name direction]
  (if (= direction :small)
  (str name " is growing smaller")
  (str name " is growing bigger")))
;; can use the function with partial to only use one arguement, the technique is called currying.

(defn toggle-grow [direction]
  (if (= direction :small) :big :small))

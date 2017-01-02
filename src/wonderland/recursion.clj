(ns wonderland.recursion)

(def adjs ["normal" "too small" "too big" "is swimming"])

(defn alice-is [in out]
(if (empty? in) ;check to see if input is empty
  out ;if in is empty it will return the result which starts as an empty vector
  (alice-is ;function is started again...
    (rest in) ;we give it the rest of the output
    (conj out ;we then apply the string to the rest and append it to the "empty" vector
      (str "alice is " (first in))))))


(defn alice-is-loop [input]
  (loop [in input ; recur jumps back to the recursion point which is the beginning of the loop and rebinds the new params to the params
    out []]
    (if (empty? in)
    out
    (recur (rest in) ; loop uses recur instaed of calling named function.
    (conj out
      (str "alice is " (first in)))))))

;only need to call it with one param using recur- loop hides the empty out vector
;loop also provides a way of not "consuming the stack"

(defn countdown [n]
  (if (= n 0)
  n
  (countdown (- n 1))))

  ; with large nubmers this will return a StackOverflowError as a new frame is added to the stack. which is a really big stack before it even starts to evaluate

  (defn countdown-recur [n]
    (if (= n 0)
    n
    (recur (- n 1))))

; this will avoid the StackOverflowError by evaluating the function args and defining a position where the call is going to jump back the recursion point. this way it only needs one stack at a time.

; using recursion you can shape and transform data which is the underlying princilple of functional programming.

; "transforming the incoming collection into another data structure. with the sideeffect and mutable state stripped away"

;map and reduce - the two main functional programming functions.

;map - the shape of the map will be the same as the incoming collection
;map takes a function and an arg - the function will take the collection as an arg

; reduce by contrast can change the number of elements in a collection

; pure function one that given the same input always returns the same output
;side effect is something else that occurs println prints to the console(side effect) and returns nil

(def animals [:mouse :duck :dodo :lory :eaglet])

(def animal-print (map #(println %) animals))
;prints nothing out until called because the sideeffects are lazy
;using doall will force the evalutation

(def birds ["dodo" "robbin" "hawk"])
(def colours ["black" "orange" "green"])
(defn gen-animal-string
  [animal color]
  (str animal " " color))


(map gen-animal-string birds (cycle ["orange" "green"]))
;map terminates at teh shortest collection, so we can use infinite lists with it


;reduce one of the most fundamental forms- it differs from map in that you can change the shape of the collection
;reduce takes a function of two arguments - the ongoing result and the element it is processing.

(def animals [:duck nil :bird :mouse])
(reduce (fn [r x] (if nil? x) r (conj r x)) [] [:duck nil :bird :mouse]))

;unlike map you cannot reduce an infinite seq as will reduce will run until one of the input seqs is empty

;filter can be better method to use, it takes a predicate and a coll
; ection as args.
;for can specify bindings for elements in a collection that we want to process


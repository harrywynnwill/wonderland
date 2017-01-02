(ns wonderland.state)


;atoms store state of something that is independent we can change the value of it independtly of changing any other state dfdf

(def who-atom (atom :caterpiller))


;de references with a preceding @

@who-atom

;can change the value of the atom using reset! these changes are made synchronously.
;idiomatic to use ! if changing state of an atom. can also use swap! to change state of the atom

(defn change [state]
  (case state
    :caterpiller :chrysalis
    :chrysalis :butterfly
    :butterfly))

(swap! who-atom change)

;the function must be free of side effects - swap operator reads the value of the atom applies the function, it then compares the current value of the atom again to make sure that another thread hasnt changed before setting the value to the result of the function

(def counter (atom 0))

@counter

(dotimes [_ 5] (swap! counter inc))
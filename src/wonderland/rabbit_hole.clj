(ns wonderland.rabbit_hole)

(def developer "Harry")


;; cmd alt r - to reload namespace into REPL
;;shift enter to run code in REPL

;; cons to add to lists
;; list are good when you want top of the list if you want something from the middle you need an index based list or a vector


;;assoc function associates new key value pairs to maps.
;;dissoc removes key value pairs from maps
;;merge merges key value pairs from one map to another

;; sets do not allow duplicates

;; clojure.set/union takes the combined items of alll of the sets.

;; clojure.set/difference like subtraction takes the elements away from one of the sets.
;; clojure.set/intersection returns only the shared elements of the sets.

;; set turns other types of collections into sets
;; contains? used to check if a set contains an element
;; conj to add to sets disj to remove from sets

;;def is used for global vars you can access them using the namespace.

;;let used for temporary vars that are only available in the context of the let.
;; let bindings are in vector form, it expects keys and values.

;; defn creates vars for functions.

(defn follow-the-rabbit [] "off we go!")
(defn shop-for-jams [jam1 jam2]
  {:jam1 jam1 :jam2 jam2})

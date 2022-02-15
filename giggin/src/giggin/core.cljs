(ns giggin.core
  (:require [reagent.core :as r]))

;; our first component
;; this is an equivalent to function app() { return (<div class="container"></div>)}
(defn app
  []
  ;; '.' means class, you can also use '#' for ID
  [:div.container])

(defn ^:export main
  []
  ;; this returns a function
  (r/render
    [app]
    (.getElementById js/document "app")))

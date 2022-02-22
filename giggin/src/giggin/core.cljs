(ns giggin.core
  (:require [reagent.core :as r]
            [reagent.example :as re]
            [giggin.components.header :as header]
            [giggin.components.gigs :as gigs]
            [giggin.components.orders :as orders]
            [giggin.components.footer :as footer]))

;; our first component
;; this is an equivalent to function app() { return (<div class="container"></div>)}
(defn app
  []
  ;; '.' means class, you can also use '#' for ID
  [:div.container
   [header/header]
   [gigs/gigs]
   [orders/orders]
   [footer/footer]
   ])

(defn ^:export main
  []
  ;; this returns a function
  (r/render [app] (.getElementById js/document "app"))
  ;; or render reagent BMI calculator example
  #_(r/render [re/bmi-component] (.getElementById js/document "app"))
  )

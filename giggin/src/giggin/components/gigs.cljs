(ns giggin.components.gigs
  (:require [giggin.state :as state]))

(defn gigs []
  [:main
   [:div.gigs (map
               (fn [{:keys [id img title price desc]}]
                 [:div.gig {:key id} ;; notice adding unique key: https://reactjs.org/docs/lists-and-keys.html#keys
                  [:img.gig__artwork {:src img :alt title}]
                       [:div.gig__body
                        [:div.gig__title
                         [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "add to order"}
                          [:i.icon.icon--plus]] title]
                        [:p.gig__price price]
                        [:p.gig__desc desc]]])
               (vals @state/gigs))]])

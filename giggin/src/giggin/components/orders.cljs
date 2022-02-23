(ns giggin.components.orders
  (:require [giggin.state :as state]))

(defn orders []
  [:aside
   [:div.order
    [:div.body
     (for [[id quant] @state/orders
           :let [{:keys [img title price] :as _item} (get @state/gigs id)]]
       [:div.item {:key id}
        [:div.img
         [:img {:src img
                :alt title}]]
        [:div.content
         ;; \u00D7 is '@'
         [:p.title (str title " \u00D7 " quant)]]
        [:div.action
         [:div.price (* price quant)]]])]]])

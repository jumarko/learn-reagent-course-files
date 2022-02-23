(ns giggin.components.orders
  (:require [giggin.state :as state]))

(defn total [orders gigs]
  (reduce-kv (fn [sum id quantity] (+ sum (* (get-in gigs [id :price]) quantity)))
             0
             orders))

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
         [:div.price (* price quant)]
         [:button.btn.btn--link.tooltip
          {:data-tooltip "Remove"
           :on-click #(swap! state/orders dissoc id)}
          [:i.icon.icon--cross]]]])]
    [:div.total
     [:hr]
     [:div.titem
      [:div.content "Total"]
      [:div.action
       [:div.price (total @state/orders @state/gigs)]]
      [:button.btn.btn--link.tooltip
       {:data-tooltip "Remove all"
        :on-click #(reset! state/orders {})}
       [:i.icon.icon--delete]]
      ]
     ]]])

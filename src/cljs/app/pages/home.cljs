(ns app.pages.home
  (:require ["/components/Anchor" :refer [Anchor]]))

(defn splash-page []
 [:div.mx-8.my-16
  [:h1.uppercase.text-5xl "ema datshi"]
  [:div.my-8
   [:h3.text-2xl.font-light "ema dashi allows you to order food from your "
    [:strong.font-medium "favourte, local restaurant"]]]
  [:> Anchor {:title "Get Started"
              :href "/restaurants"
              :className "px-8"}]])


(defn home-page []
  [splash-page])

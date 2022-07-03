(ns app.pages.home
  (:require ["/components/Button" :refer [Button]]))

(defn splash-page []
 [:div.m-8
  [:h1.uppercase.text-5xl "ema datshi"]
  [:div.my-8
   [:h3.text-2xl.font-light "ema dashi allows you to order food from your "
    [:strong.font-medium "favourte, local restaurant"]]
   [:> Button {:title "Get Started"
               :className "px-8"}]]])


(defn home-page []
  [splash-page])

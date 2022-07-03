(ns app.components.navbar
  ;; TODO: tech debt: refactor
  (:require [app.routes :refer [routes-state]]))

(comment
  (-> @routes-state :data :name))


(defn is-active? [rs route-name]
    (= (-> rs :data :name)
       route-name))

(comment
  (is-active? @routes-state :routes/home)
  (is-active? @routes-state :routes/restaurants))



(defn navbar []
  [:nav.m-8.flex.justify-between.items-stretch.items-center
   [:a {:href "/"}
    [:img.h-8 {:src "img/hot.png"}]]
   [:div.flex.grid-gap-2
    [:p.mx-4 {:class [(when (is-active? @routes-state :routes/how) "font-medium")]}
     [:a {:href "/how"} "how it works"]]
    [:p.mx-4 {:class [(when (is-active? @routes-state :routes/restaurants) "font-medium")]}
     [:a {:href "/restaurants"} "restaurants"]]
    [:p.mx-4  {:class [(when (is-active? @routes-state :routes/login) "font-medium")]}
     [:a {:href "/login"} "login"]]
    [:p.mx-4 {:class [(when (is-active? @routes-state :routes/register) "font-medium")]}
     [:a {:href "/register"} "register"]]]])

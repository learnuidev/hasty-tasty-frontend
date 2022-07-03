(ns app.components.navbar)

(defn navbar []
  [:nav.m-8.flex.justify-between.items-stretch
   [:h1.font-600 [:a {:href "/"} "ema datshi"]]
   [:div.flex.grid-gap-2
    [:p.mx-4 [:a {:href "/how"} "how it works"]]
    [:p.mx-4 [:a {:href "/restaurants"} "restaurants"]]
    [:p.mx-4 [:a {:href "/login"} "login"]]
    [:p.mx-4 [:a {:href "/register"} "register"]]]])

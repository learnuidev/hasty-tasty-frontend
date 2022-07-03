(ns app.routes
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend.controllers :as rfc]
            [reitit.coercion.spec :as rss]
            ;; pages
            [app.pages.how :refer [how-page]]
            [app.pages.restaurants :refer [restaurants-page]]
            [app.pages.home :refer [home-page]]
            [app.pages.login :refer [login-page]]
            [app.pages.register :refer [register-page]]
            [app.pages.settings :refer [settings-page]]
            [app.pages.profile :refer [profile-page]]))


(defonce routes-state (r/atom nil))

(defonce temp (atom nil))

(comment
  @temp)

(def routes
  [["/"         {:name :routes/home
                 :view #'home-page}]
                 ; :controllers [{:start (fn []
                 ;                         (tags/tags-browse)
                 ;                         (if (get-token)
                 ;                           (do
                 ;                             (reset! articles/tab-state :feed)
                 ;                             (articles/articles-feed))
                 ;                           (do
                 ;                             (reset! articles/tab-state :all)
                 ;                             (articles/articles-browse))))
                 ;                :stop (fn []
                 ;                        (tags/reset-tags))}]}]
   ["/login"    {:name :routes/login
                 :view #'login-page
                 :controllers [{:start #(js/console.log "enter - login page")
                                :stop #(js/console.log  "exit - login page")}]}]
   ["/register" {:name :routes/register
                 :view #'register-page}]
                 ; :controllers [{:start #(js/console.log "enter - register page")
                 ;                :stop (fn []
                 ;                        (js/console.log "leave - register page")
                 ;                        (when (seq @auth/error-state)
                 ;                          (reset! auth/error-state nil)))}]}]
   ["/settings" {:name :routes/settings
                 :view #'settings-page}]
   ["/how" {:name :routes/how
            :view #'how-page}]
   ["/restaurants" {:name :routes/restaurants
                    :view #'restaurants-page}]
   ["/user/:username" {:name :routes/profile
                       :view #'profile-page
                       :parameters
                       {:path {:username string?}}}]])
                        ; :controllers
                        ; [{:params (fn [match]
                        ;             (:path (:parameters match)))
                        ;   :start (fn [{:keys [username] :as props}]
                        ;            (profile/fetch! username)
                        ;            (articles/fetch-by username)
                        ;            (println "Entering Profile of - " username)
                        ;            (reset! temp props))
                        ;   :stop (fn []
                        ;           (reset! profile/tab-state :author)
                        ;           (reset! profile/profile-state nil))}]}]])

(comment "takes route name and generates the route path, nil if not found"
         (rfe/href ::login))


(comment
  @routes-state)

(defn router-start! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion
                             :controllers [{:start (fn [] (println "Root controller start"))
                                            :stop #(println "Root controller stop")}]}})
   (fn [new-match] (swap! routes-state (fn [old-match]
                                         (if new-match
                                           (assoc new-match :controllers (rfc/apply-controllers (:controllers old-match) new-match))))))
    ;; set to false to enable HistoryAPI
   {:use-fragment false}))

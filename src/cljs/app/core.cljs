(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [reagent.dom :as rdom]
            ;; aws
            ; ["/aws/amplify" :as amplify]
            [app.amplify :as amp]
            [app.auth]
            ;; Layout
            [app.layout :refer [app]]
            ;; router
            [app.routes :refer [router-start!]]))
            ; [app.view :refer [main-view]]))

;; configure aws
(amp/configure-user-pool!)
(amp/configure-appsync!)


(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (rdom/render [app] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (router-start!)
  (render))

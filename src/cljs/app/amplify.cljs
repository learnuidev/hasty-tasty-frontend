(ns app.amplify
  (:require [app.config :refer [env]]
            ["/aws/amplify" :as amplify]))


;; 1. Configuring User Pool
(defn configure-user-pool! []
  (amplify/configureUserPool (clj->js {:region (-> env :region)
                                       :userPoolId (-> env :userPoolId)
                                       :userPoolWebClientId (-> env :userPoolWebClientId)
                                       :graphqlEndpoint (-> env :graphqlEndpoint)
                                       :mandatorySignIn true})))

;; 2. Configure App Sync
(defonce app-config
  {:graphqlEndpoint (-> env :graphqlEndpoint)
   :region (-> env :region)
   :authenticationType (-> env :authenticationType)})

(defn configure-appsync! []
  (amplify/configureAppSync (clj->js app-config)))

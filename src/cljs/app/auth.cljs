(ns ^{:doc "Auth Module"
      :author "Vishal Gautam"}
  app.auth
  (:require [reagent.core :as r]
            ["/aws/auth" :as auth]
            ["aws-amplify" :refer [Auth]]))


(defonce auth-state (r/atom nil))

;; whats methods does Auth expose
;; Auth
;; 1. Sign Up
(comment)
(defn sign-up! [{:keys [username password email name]}]
  (-> (auth/signUp (clj->js {:username username
                             :password password
                             :email email
                             :name name}))
      (.then #(js/console.log %))))

(comment
  (sign-up! {:username "learnuidev@gmail.com"
             :password "f@g/A/3]]gwS@fk&"
             :email "learnuidev@gmail.com"
             :name "Vishal Gautam"}))



;; 2. Resend Code
(comment)
(defn resend-code [username]
  (-> (auth/resendCode username)
      (.then #(js/console.log %))))

(comment
  (resend-code "learnuidev@gmail.com"))

;; 3. Confirm Signup
(defn confirm-signup! [{:keys [username code]}]
  (-> (auth/confirmSignUp (clj->js {:username username
                                    :code (str code)}))
      (.then #(js/console.log %))))


(comment
 (confirm-signup! {:username "learnuidev@gmail.com"
                   :code "296605"}))

;; 4. Sign In
(comment)
(defn sign-in! [{:keys [username password]}]
  (-> (auth/signIn (clj->js {:username username :password password}))
      (.then #(reset! auth-state (js->clj % :keywordize-keys true)))))

(comment
  (:jwtToken @auth-state)
  (sign-in! {:username "learnuidev@gmail.com"
             :password "f@g/A/3]]gwS@fk&"}))

;;
;; Step 5: get current credentials
(set! js/window -auth Auth)

;; Step 4.5 - get auth user
(comment
  (-> (auth/getAuthUser)
      (.then #(js/console.log %))))

;; 5 Signout
(comment
  (auth/signOut))

;; check user again
(comment
  (-> (auth/getAuthUser)
      (.then #(js/console.log %))
      (.catch #(js/console.log "TODO"))))
  ;; => nil

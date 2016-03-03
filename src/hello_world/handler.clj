(ns hello-world.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (resource-response "hello-world.html" {:root "public"}))
  (GET "/about" [] (resource-response "about.html" {:root "public"}))
  (route/resources "/")
  (route/not-found "Sorry, this page has not been found."))

  (def app
    (handler/api app-routes))

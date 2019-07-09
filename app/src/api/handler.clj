(ns api.handler
  (:require [compojure.core :refer :all]
    [compojure.handler :as handler]
    [compojure.route :as route]
    [ring.middleware.json :as json]
    [ring.util.response :refer [response]]
    [ring.util.response :refer [status]]
    [todo.handler :as todo]
    [user.handler :as user]
    ))
 
(defroutes base-routes 
  (GET "/" []
    (response "Hello World"))
  (route/resources "/")
  (route/not-found "Not Found")
)
(defroutes app-routes todo/todo-routes user/user-routes base-routes)

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))

  
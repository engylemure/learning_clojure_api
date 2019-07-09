(ns user.handler
  (:require [compojure.core :refer :all]
    [compojure.handler :as handler]
    [compojure.route :as route]
    [ring.middleware.json :as json]
    [ring.util.response :refer [response]]
    [ring.util.response :refer [status]]
    [user.query :refer :all]
    [clj-time.core :as time]
    [clj-time.format :as f]
    ))

(defroutes user-routes  
  (GET "/" []
    (response "Hello World"))
  (GET "/api/users" []
    (response (get-users)))
  (GET "/api/users/:id" [id]
    (let [
      todo (get-user (Integer/parseInt id))
    ] (if todo
      (response todo)
      (status (response todo) 404)
    )))
  (POST "/api/users" {:keys [params]}
    (let [{:keys [title description]} params]
      (response (add-user title description (f/unparse (f/formatters :mysql) (time/now))))))
  (PUT "/api/users/:id" [id title is_complete]
    (response (update-user (Integer/parseInt id) title is_complete)))
  (DELETE "/api/users/:id" [id]
    (response (delete-user (Integer/parseInt id))))  
)
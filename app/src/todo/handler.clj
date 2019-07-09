(ns todo.handler
  (:require [compojure.core :refer :all]
    [compojure.handler :as handler]
    [compojure.route :as route]
    [ring.middleware.json :as json]
    [ring.util.response :refer [response]]
    [ring.util.response :refer [status]]
    [todo.query :refer :all]
    [clj-time.core :as time]
    [clj-time.format :as f]
    ))

(defroutes todo-routes  
  (GET "/api/todos" []
    (response (get-todos)))
  (GET "/api/todos/:id" [id]
    (let [
      todo (get-todo (Integer/parseInt id))
    ] (if todo
      (response todo)
      (status (response todo) 404)
    )))
  (POST "/api/todos" {:keys [params]}
    (let [{:keys [title description]} params]
      (response (add-todo title description (f/unparse (f/formatters :mysql) (time/now))))))
  (PUT "/api/todos/:id" [id title is_complete]
    (response (update-todo (Integer/parseInt id) title is_complete)))
  (DELETE "/api/todos/:id" [id]
    (response (delete-todo (Integer/parseInt id))))
)

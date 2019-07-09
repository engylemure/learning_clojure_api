(ns todo.query
  (:refer-clojure :exclude [update])
  (:require [api.database]
            [korma.core :refer :all]))

(defentity todos)

(defn get-todos []
  (select todos))

(defn add-todo [title description created_at]
  (insert todos
          (values {:title title :description description :created_at created_at})))

(defn delete-todo [id]
  (delete todos
          (where {:id [= id]})))

(defn update-todo [id title is-complete]
  (update todos
          (set-fields {:title title
                       :is_complete is-complete})
          (where {:id [= id]})))

(defn get-todo [id]
  (first
    (select todos
          (where {:id [= id]}))))
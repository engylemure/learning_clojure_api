(ns user.query
  (:require [api.database]
            [korma.core :refer :all]))

(defentity items)

(defn get-users []
  (select items))

(defn add-user [title description created_at]
  (insert items
          (values {:title title :description description :created_at created_at})))

(defn delete-user [id]
  (delete items
          (where {:id [= id]})))

(defn update-user [id title is-complete]
  (update items
          (set-fields {:title title
                       :is_complete is-complete})
          (where {:id [= id]})))

(defn get-user [id]
  (first
    (select items
          (where {:id [= id]}))))
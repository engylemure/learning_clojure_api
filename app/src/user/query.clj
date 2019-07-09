(ns user.query
  (:refer-clojure :exclude [update])
  (:require [api.database]
            [korma.core :refer :all]))

(defentity users)

(defn get-users []
  (select users))

(defn add-user [title description created_at]
  (insert users
          (values {:title title :description description :created_at created_at})))

(defn delete-user [id]
  (delete users
          (where {:id [= id]})))

(defn update-user [id title is-complete]
  (update users
          (set-fields {:title title
                       :is_complete is-complete})
          (where {:id [= id]})))

(defn get-user [id]
  (first
    (select users
          (where {:id [= id]}))))
(ns api.database
  (:require [korma.db :as korma]))

(def db-connection-info 
    (korma/mysql 
        {:classname "com.mysql.cj.jdbc.Driver"
        :subprotocol "mysql"
        :user "root"
        :password "root"
        :subname "//db:3306/learning_clojure_api"}))

; set up korma
(korma/defdb db db-connection-info)
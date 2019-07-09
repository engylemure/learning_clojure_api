  
(defproject todo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [ [org.clojure/clojure "1.10.0"]
                  [compojure "1.6.1"]
                  [ring/ring-core "1.7.1"]
                  [ring/ring-json "0.4.0"]
                  [korma "0.4.3"]
                  [mysql/mysql-connector-java "8.0.16"]
                  [ring/ring-defaults "0.3.2"]
                  [migratus "1.2.3"]
                  [clj-time "0.15.0"]
                 ]
  :plugins [[lein-ring "0.12.5"] [migratus-lein "0.7.2"]] 
  :ring {:handler api.handler/app}
  :migratus {:store :database
  :migration-dir "./migrations"
  :db {:classname "com.mysql.cj.jdbc.Driver"
       :subprotocol "mysql"
       :subname "//db:3306/learning_clojure_api"
       :user "root"
       :password "root"}}
  :profiles
  {:dev {:dependencies [[javax.servlet/javax.servlet-api "4.0.1"]
                        [ring/ring-mock "0.4.0"]]}})
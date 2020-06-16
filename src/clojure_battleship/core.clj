(ns clojure-battleship.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))

(defn simple-body-page [req]
  {:status 200
   :headers {"Content-type" "text/html"}
   :body "hello world"})

(defn request-example [req]
  {:status 200
   :headers {"Content-type" "text/html"}
   :body (->>
          (pp/pprint req)
          (str "Request Object:" req))})


(defroutes app-routes
  (GET "/" [] simple-body-page)
  (GET "/request" [] request-example)
  (route/not-found "Error, page not found!"))


(defn -main
  "Main Entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8765"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults)
                       {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))




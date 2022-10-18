(ns book-library.service
  (:require [book-library.diplomat.http-server :as http-server]
            [io.pedestal.http :as http]))

;;TODO (1) - extract server to its own namespace

(defn create-server []
  (http/create-server
   {::http/routes http-server/routes
    ::http/type :jetty
    ::http/port 8890}))

(defn start []
  (http/start (create-server)))
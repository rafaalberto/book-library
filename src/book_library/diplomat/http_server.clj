(ns book-library.diplomat.http-server
  (:require [book-library.controller.book :as controller.book]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(defn find-book [_]
  {:status 200
   :body   (controller.book/find-book)})

(def ^:private commons-json-interceptor [http/json-body])

(def route-table
  #{["/book"
     :get (conj commons-json-interceptor 'find-book)
     :route-name :find-book]})

(def routes
  (route/expand-routes route-table))
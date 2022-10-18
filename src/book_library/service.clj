(ns book-library.service
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http :as http]))

(defonce server (atom nil))

(defn start! [service-map]
  (reset! server (http/start (http/create-server service-map))))

(defn stop! []
  (http/stop @server))

(defn restart! [service-map]
  (stop!)
  (start! service-map))

(defn start-server! [service-map]
  (try (start! service-map) (catch Exception ex (println "Error to start" (.getMessage ex))))
  (try (restart! service-map) (catch Exception ex (println "Error to restart" (.getMessage ex)))))

(defrecord Server [routes]
  component/Lifecycle

  (start [this]
    (let [service-map {::http/routes (:routes routes)
                       ::http/type   :jetty
                       ::http/port   8890
                       ::http/join?  false}
          _ (start-server! service-map)])
    (assoc this :http-server server))

  (stop [this]
    (dissoc this :http-server server)))

(defn new-server []
  (->Server {}))

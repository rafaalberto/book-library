(ns book-library.routes
  (:require [com.stuartsierra.component :as component]))

(defrecord Routes [routes]
  component/Lifecycle

  (start [this]
    (assoc this :routes routes))

  (stop [this]
    (dissoc this :routes routes)))

(defn new-routes [routes]
  (->Routes routes))

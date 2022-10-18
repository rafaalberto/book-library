(ns book-library.components
  (:require [book-library.diplomat.http-server :as http-server]
            [book-library.routes :as routes]
            [book-library.service :as service]
            [com.stuartsierra.component :as component]))

(defn base []
  (component/system-map
   :routes (routes/new-routes http-server/routes)
   :http-server (component/using (service/new-server) [:routes])))

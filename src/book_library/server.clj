(ns book-library.server
  (:gen-class)
  (:require [book-library.components :as components]
            [com.stuartsierra.component :as component]))

(defn -main [& _]
  (component/start (components/base)))

(ns book-library.core
  (:gen-class)
  (:require [book-library.service :as service]))

(defn -main [& _]
  (service/start))


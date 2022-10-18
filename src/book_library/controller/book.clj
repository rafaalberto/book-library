(ns book-library.controller.book
  (:require [book-library.logic.book :as logic.book]))

(defn find-book []
  (let [book (logic.book/find-book)]
    (println book)
    book))
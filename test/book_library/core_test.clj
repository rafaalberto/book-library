(ns book-library.core-test
  (:require [book-library.logic.book :as book]
            [clojure.test :refer :all]))

(deftest find-book-test
  (testing "Finding a book"
    (is (= {:id       1
            :name     "Clojure's book"
            :quantity 3}
           (book/find-book)))))

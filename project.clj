(defproject book-library "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.route "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [org.slf4j/slf4j-simple "1.7.36"]
                 [com.stuartsierra/component "1.1.0"]]
  :plugins [[lein-cljfmt "0.9.0"]
            [lein-nsorg "0.3.0"]]
  :aliases {"clean-ns" ["nsorg" "--replace"]
            "lint-fix" ["do" ["clean-ns"] ["cljfmt" "fix"]]}
  :repl-options {:init-ns book-library.server})

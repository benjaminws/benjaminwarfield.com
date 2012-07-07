(defproject benjaminwarfield "0.1.0-SNAPSHOT"
  :description "My personal website"
  :url "http://benjaminwarfield.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [compojure "1.1.0"]]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler benjaminwarfield.core/app})

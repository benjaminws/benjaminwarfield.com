(defproject benjaminwarfield "0.1.0-SNAPSHOT"
  :description "My personal website"
  :url "http://benjaminwarfield.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [compojure "1.1.0"]
                 [hiccup "1.0.0"]
                 [kerodon "0.0.4"]
                 [ring/ring-jetty-adapter "1.1.8"]]

  :plugins [[lein-ring "0.7.1"]
            [lein-lesscss "1.2"]]
  :ring {:handler benjaminwarfield.routes/app}
  :lesscss-paths ["resources/less"]
  :lesscss-output-path "resources/public/stylesheets")

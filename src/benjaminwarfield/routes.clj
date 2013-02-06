(ns benjaminwarfield.routes
  (:use compojure.core
        benjaminwarfield.views
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [ring.adapter.jetty :as jetty]))

(def article-slug #"([0-9]{4})/([0-9]{1,2})/([0-9]{2})/([a-zA-Z\\-]+\.html)")

(defroutes main-routes
  (GET "/" [] (index-view))
  (GET "/about" [] (about-view))
  (GET "/articles" [] (list-articles))
  (GET ["/articles/:article" :article article-slug] [article] (article-view article))
  (route/resources "/")
  (route/not-found (four-oh-four-view)))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))

(defn run []
  (def port (Integer/parseInt (get (System/getenv) "PORT")))
  (jetty/run-jetty main-routes {:port port, :host "0.0.0.0"}))

(defn -main [& args]
  (run))

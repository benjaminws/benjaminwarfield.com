(ns benjaminwarfield.routes
  (:use compojure.core
        benjaminwarfield.views
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (index-view))
  (GET "/about" [] (about-view))
  (route/resources "/")
  (route/not-found (four-oh-four-view)))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))


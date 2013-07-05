(ns benjaminwarfield.views
	(:use [hiccup core page def element])
    (:require [clojure.java.io :as io])
    (:gen-class))

(defhtml html-head []
  [:head
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
    [:title "Benjamin Warfield Smith"]
    (include-css "/stylesheets/base.css")
    (include-css "/stylesheets/bootstrap-responsive.min.css")
    (include-css "/stylesheets/shCore.css")
    (include-css "/stylesheets/shThemeDefault.css")
    (include-js "/javascripts/analytics.js")
    (include-js "/javascripts/shCore.js")
    (include-js "/javascripts/refocus.js")
    (include-js "/javascripts/refocusConfig.js")
    (include-js "/javascripts/bootstrap.min.js")])

(defhtml page-header []
  [:div.header
    [:div.container
      [:div.group
        [:div.brand
          [:a {:href "/"} "Benjamin Warfield Smith"]]]]])

(defhtml page-content [content]
  [:div.container
    [:div.content content]])

(defhtml index-content []
  [:h2 "Hey ya'll"]
  [:p [:a.about {:href "/about"} "Who do I think I am?"]])

(defhtml about-content []
  [:h2 "Developer and Ops guy."]
  [:div.around_the_web
    [:ul
      [:li [:a {:href "http://twitter.com/benjaminws"} "Twitter"]]
      [:li [:a {:href "http://github.com/benjaminws"} "Github"]]
      [:li [:a {:href "http://designinginteractive.com"} "Designing Interactive"]]
      [:li [:a {:href "http://pgp.mit.edu:11371/pks/lookup?op=get&search=0x8EA10315498C1579"} "GPG Key"]]]])

(def articles-root (str (System/getProperty "user.dir") "/articles/"))

(defn article-html [article-path]
  (slurp (str article-path)))

(defn all-articles []
  (filter #(.endsWith (.getName %) ".html") (file-seq (io/file articles-root))))

(defn index-view []
  (html5
    (html-head)
      (page-header)
        (page-content
          (index-content))))

(defn about-view []
  (html5
    (html-head)
      (page-header)
        (page-content
          (about-content))))

(defn article-view [article-path]
  (html5
    (html-head)
      (page-header)
        (page-content
          (article-html (str articles-root article-path)))))

(defn list-articles []
   (html5
    (html-head)
      (page-header)
        (page-content
          (map article-html (all-articles)))))

(defn four-oh-four-view []
  (html5
    (html-head)
      (page-header)
        (page-content
          [:h2 "404 - >:-c"])))

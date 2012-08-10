(ns benjaminwarfield.views
	(:use [hiccup core page def element]))

(defhtml html-head []
  [:head
    [:title "Benjamin Warfield Smith"]
    (include-css "/stylesheets/base.css")
    (include-js "/javascripts/analytics.js")])

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
  [:h2 "Welcome to Thunderdome, bitch."]
  [:p [:a.about {:href "/about"} "Who the crap do I think I am?"]])

(defn index-view []
  (html5
    (html-head)
      (page-header)
        (page-content
          (index-content))))

(defhtml about-content []
  [:h2 "Developer and Ops guy."]
  [:p "I run Bartertown."]
  [:div.around_the_web
    [:ul
      [:li [:a {:href "http://twitter.com/benjaminws"} "Twitter"]]
      [:li [:a {:href "http://github.com/benjaminws"} "Github"]]
      [:li [:a {:href "http://designinginteractive.com"} "Designing Interactive"]]]])

(defn about-view []
  (html5
   (html-head)
    (page-header)
     (page-content
       (about-content))))

(defn four-oh-four-view []
  (html5
    (html-head)
      (page-header)
        (page-content
          [:h2 "404 - U MAD?"])))

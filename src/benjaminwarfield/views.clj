(ns benjaminwarfield.views
	(:use [hiccup core page]))

(defn index-view []
	(html5
		[:head
		  [:title "Benjamin Warfield Smith"]
		  (include-css "/stylesheets/base.css")]
		[:body
		  [:div {:class "container"}
            [:h1 "Benjamin W. Smith"]
            [:span "Welcome to the thunderdome, bitch."]]]))

(defn four-oh-four-view []
	(html5
		[:head
		  [:title "Benjamin Warfield Smith"]
		  (include-css "/stylesheets/base.css")]
		[:body
		  [:div {:class "container"}
		  [:h1 "404 - U MAD?"]]]))
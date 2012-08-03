(ns benjaminwarfield.views
	(:use [hiccup core page def]))

(defhtml html-head []
  [:head
    [:title "Benjamin Warfield Smith"]
    (include-css "/stylesheets/base.css")])

(defhtml page-header []
  [:div {:class "header"}
    [:div {:class "container"}
      [:div {:class "group"}
        [:div {:class "brand"}
          [:a {:href "/"} "Benjamin Warfield Smith"]]]]])

(defhtml page-content [content]
  [:div {:class "container"}
    [:div {:class "content"} content]])

(defhtml index-content []
  [:h2 "Welcome to Thunderdome, bitch."]
  [:p [:a {:href "/about"} "Who the crap do I think I am?"]])

(defn index-view []
  (html5
    (html-head)
      (page-header)
        (page-content
          (index-content))))

(defhtml about-content []
  [:h2 "Master Blaster"]
  [:p "I run Bartertown."])

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

(ns leiningen.article
  (:use [markdown])
  (:require [clojure.java.io :as io])
  (:import [java.io File FileReader FileWriter])
  (:import [java.util Calendar]))

(defn get-articles-path []
  (let [c (Calendar/getInstance)
        YY (.get c Calendar/YEAR)
        MM (.get c Calendar/MONTH)
        DD (.get c Calendar/DAY_OF_MONTH)]
  (format "./articles/%d/%d/%d/" YY MM DD)))

(defn ls [path]
  (let [file (File. path)]
    (if (.isDirectory file)
      (seq (.list file))
      (when (.exists file)
        [path]))))

(defn mkdir [path]
  (.mkdirs (io/file path)))

(defn ensure-directory! [path]
  (when-not (ls path)
    (mkdir path)))

(defn ensure-file! [path]
    (when-not (ls path)
      (.createNewFile (io/file path))))

(defn create [project article-name & args]
  (let [full-article-path (format "%s%s.md" (get-articles-path) article-name)]
  (ensure-directory! (get-articles-path))
  (ensure-file! full-article-path)
  (println (format "Created article at: %s" full-article-path))))

(defn publish [project article-path & args]
  (let [article-destination
    (format "%s/%s.html"
      (.getParent (io/as-file article-path))
      (first (.split (.getName (io/as-file article-path)) "\\.")))]
  (markdown/md-to-html
    (new FileReader article-path)
    (new FileWriter article-destination))
  (println (format "Published article at: %s" article-destination))))

(defn article
  "Create and publish new articles."
  [project subtask & args]
    (case subtask
      "create" (apply create project args)
      "publish" (apply publish project args)
               (println "Subtask" (str \" subtask \") "not found.")))

(ns leiningen.article
  (:require [clojure.java.io :as io])
  (:import java.io.File)
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
  (let [full-article-path (format "%s/%s.md" (get-articles-path) article-name)]
  (println (format "Creating article at: %s" full-article-path))
  (ensure-directory! (get-articles-path))
  (ensure-file! full-article-path)))

(defn publish
  ([project & args] (println "IMPLEMENT ME")))

(defn article
  "Create and publish new articles."
  [project subtask & args]
    (case subtask
      "create" (apply create project args)
      "publish" (apply publish project args)
               (println "Subtask" (str \" subtask \") "not found.")))

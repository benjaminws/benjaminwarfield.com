(ns benjaminwarfield.integration-test
  (:use [kerodon.core]
        [kerodon.test]
        [clojure.test]
        [benjaminwarfield.routes]))

(deftest index-status-test
  (-> (session app)
      (visit "/")
      (has (status? 200))))

(deftest base-header-test
  (-> (session app)
      (visit "/")
      (within [:.brand :a]
        (has (text? "Benjamin Warfield Smith")
            "Base header has expected content"))))

(deftest index-content-test
    (-> (session app)
        (visit "/")
        (within [:.content :h2]
          (has (text? "Welcome to Thunderdome, bitch.")
              "Index has expected content"))))

(deftest four-oh-four-status-test
  (-> (session app)
      (visit "/404")
      (has (status? 404)
          "Page was not found")))

(deftest four-oh-four-content-test
  (-> (session app)
      (visit "/404")
      (within [:.content :h2]
        (has (text? "404 - U MAD?")
            "404 page has expected content"))))

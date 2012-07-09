(ns benjaminwarfield.integration-test
  (:use [kerodon.core]
        [kerodon.test]
        [clojure.test]
        [benjaminwarfield.routes]))

(deftest index-test
  (-> (session app)
      (visit "/")
      (has (status? 200)
          "Page was found")
      (within [:.container :h1]
        (has (text? "Benjamin Warfield Smith")
            "Index page has expected text"))))

(deftest four-oh-four-test
  (-> (session app)
      (visit "/404")
      (has (status? 404)
          "Page was not found")
      (within [:.container :h1]
        (has (text? "404 - U MAD?")
            "404 page has expected text"))))

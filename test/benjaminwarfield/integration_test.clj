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
          (has (text? "Hey ya'll")
              "Index has expected content"))
         (within [:.content :a]
           (has (text? "Who do I think I am?")))))

(deftest index-follow-to-about-test
    (-> (session app)
        (visit "/")
        (follow [:a.about])
        (has (status? 200))))

(deftest about-status-test
  (-> (session app)
      (visit "/about")
      (has (status? 200))))

(deftest about-content-test
  (-> (session app)
      (visit "/about")
      (within [:.content :h2]
        (has (text? "Developer and Ops guy.")
             "Page header has expected content"))))

(deftest four-oh-four-status-test
  (-> (session app)
      (visit "/404")
      (has (status? 404)
          "Page was not found")))

(deftest four-oh-four-content-test
  (-> (session app)
      (visit "/404")
      (within [:.content :h2]
        (has (text? "404 - >:-c")
            "404 page has expected content"))))

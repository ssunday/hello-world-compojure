(ns hello-world.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [hello-world.handler :refer :all]))

(deftest test-app
  (testing "default directory"
    (let [response (app (mock/request :get "/"))]
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

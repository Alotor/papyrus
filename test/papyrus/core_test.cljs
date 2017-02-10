(ns papyrus.core-test
    (:require-macros [cljs.test :refer [deftest testing is async]])
    (:require [cljs.test]
              [papyrus.core :as core]))

(enable-console-print!)

(deftest success-test []
  (.log js/console "..." worker)
  (is (= (.round js/Math 2.2) core/two)))



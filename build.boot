(set-env!
  :source-paths #{"src"}
  :dependencies
  '[[crisptrutski/boot-cljs-test "0.3.0" :scope "test"]
    [adzerk/boot-test            "1.0.6"]])

(require
  '[adzerk.boot-test            :refer :all]
  '[crisptrutski.boot-cljs-test :refer [test-cljs report-errors!] :as cljs-test])

(deftask tests []
  (merge-env! :source-paths #{"test"})
  (task-options! test-cljs {:js-env :node})
  (test-cljs))

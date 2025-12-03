(ns cell-ml-model-repository-api.specs.search-repository-200-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [cell-ml-model-repository-api.specs.search-result :refer :all]
            )
  (:import (java.io File)))


(def search-repository-200-response-data
  {
   (ds/opt :items) (s/coll-of search-result-spec)
   (ds/opt :total) int?
   })

(def search-repository-200-response-spec
  (ds/spec
    {:name ::search-repository-200-response
     :spec search-repository-200-response-data}))

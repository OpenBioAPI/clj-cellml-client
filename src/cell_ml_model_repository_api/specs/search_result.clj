(ns cell-ml-model-repository-api.specs.search-result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def search-result-data
  {
   (ds/opt :id) string?
   (ds/opt :title) string?
   (ds/opt :description) string?
   (ds/opt :portal_type) string?
   (ds/opt :url) string?
   })

(def search-result-spec
  (ds/spec
    {:name ::search-result
     :spec search-result-data}))

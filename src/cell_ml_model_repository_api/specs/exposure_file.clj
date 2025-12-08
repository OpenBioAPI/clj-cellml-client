(ns cell-ml-model-repository-api.specs.exposure-file
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [cell-ml-model-repository-api.specs.exposure-file-view :refer :all]
            )
  (:import (java.io File)))


(def exposure-file-data
  {
   (ds/opt :id) string?
   (ds/opt :title) string?
   (ds/opt :path) string?
   (ds/opt :views) (s/coll-of exposure-file-view-spec)
   (ds/opt :documentation) string?
   })

(def exposure-file-spec
  (ds/spec
    {:name ::exposure-file
     :spec exposure-file-data}))

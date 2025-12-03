(ns cell-ml-model-repository-api.specs.exposure-file-summary
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def exposure-file-summary-data
  {
   (ds/opt :path) string?
   (ds/opt :title) string?
   (ds/opt :views) (s/coll-of string?)
   })

(def exposure-file-summary-spec
  (ds/spec
    {:name ::exposure-file-summary
     :spec exposure-file-summary-data}))

(ns cell-ml-model-repository-api.specs.exposure
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [cell-ml-model-repository-api.specs.exposure-curation :refer :all]
            [cell-ml-model-repository-api.specs.exposure-file-summary :refer :all]
            )
  (:import (java.io File)))


(def exposure-data
  {
   (ds/opt :id) string?
   (ds/opt :title) string?
   (ds/opt :description) string?
   (ds/opt :workspace) string?
   (ds/opt :commit_id) string?
   (ds/opt :created) inst?
   (ds/opt :modified) inst?
   (ds/opt :curation) exposure-curation-spec
   (ds/opt :files) (s/coll-of exposure-file-summary-spec)
   })

(def exposure-spec
  (ds/spec
    {:name ::exposure
     :spec exposure-data}))

(ns cell-ml-model-repository-api.specs.exposure-summary
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def exposure-summary-data
  {
   (ds/opt :id) string?
   (ds/opt :title) string?
   (ds/opt :description) string?
   (ds/opt :url) string?
   (ds/opt :workspace) string?
   })

(def exposure-summary-spec
  (ds/spec
    {:name ::exposure-summary
     :spec exposure-summary-data}))

(ns cell-ml-model-repository-api.specs.exposure-file-view
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def exposure-file-view-data
  {
   (ds/opt :id) string?
   (ds/opt :label) string?
   (ds/opt :url) string?
   })

(def exposure-file-view-spec
  (ds/spec
    {:name ::exposure-file-view
     :spec exposure-file-view-data}))

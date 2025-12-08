(ns cell-ml-model-repository-api.specs.repository-info
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def repository-info-data
  {
   (ds/opt :title) string?
   (ds/opt :description) string?
   (ds/opt :workspace_count) int?
   (ds/opt :exposure_count) int?
   })

(def repository-info-spec
  (ds/spec
    {:name ::repository-info
     :spec repository-info-data}))

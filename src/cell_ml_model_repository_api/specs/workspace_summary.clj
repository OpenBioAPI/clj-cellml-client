(ns cell-ml-model-repository-api.specs.workspace-summary
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def workspace-summary-data
  {
   (ds/opt :id) string?
   (ds/opt :title) string?
   (ds/opt :description) string?
   (ds/opt :url) string?
   })

(def workspace-summary-spec
  (ds/spec
    {:name ::workspace-summary
     :spec workspace-summary-data}))

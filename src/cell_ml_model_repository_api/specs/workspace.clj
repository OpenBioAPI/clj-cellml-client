(ns cell-ml-model-repository-api.specs.workspace
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [cell-ml-model-repository-api.specs.file-info :refer :all]
            )
  (:import (java.io File)))


(def workspace-data
  {
   (ds/opt :id) string?
   (ds/opt :title) string?
   (ds/opt :description) string?
   (ds/opt :storage) string?
   (ds/opt :owner) string?
   (ds/opt :created) inst?
   (ds/opt :modified) inst?
   (ds/opt :files) (s/coll-of file-info-spec)
   })

(def workspace-spec
  (ds/spec
    {:name ::workspace
     :spec workspace-data}))

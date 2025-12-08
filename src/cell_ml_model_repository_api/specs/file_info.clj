(ns cell-ml-model-repository-api.specs.file-info
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def file-info-data
  {
   (ds/opt :path) string?
   (ds/opt :size) int?
   (ds/opt :mimetype) string?
   })

(def file-info-spec
  (ds/spec
    {:name ::file-info
     :spec file-info-data}))

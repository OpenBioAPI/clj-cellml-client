(ns cell-ml-model-repository-api.specs.exposure-curation
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def exposure-curation-data
  {
   (ds/opt :flags) (s/coll-of string?)
   (ds/opt :stars) int?
   })

(def exposure-curation-spec
  (ds/spec
    {:name ::exposure-curation
     :spec exposure-curation-data}))

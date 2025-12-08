(ns cell-ml-model-repository-api.api.default
  (:require [cell-ml-model-repository-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [cell-ml-model-repository-api.specs.exposure-file-view :refer :all]
            [cell-ml-model-repository-api.specs.exposure-summary :refer :all]
            [cell-ml-model-repository-api.specs.workspace-summary :refer :all]
            [cell-ml-model-repository-api.specs.workspace :refer :all]
            [cell-ml-model-repository-api.specs.exposure :refer :all]
            [cell-ml-model-repository-api.specs.search-result :refer :all]
            [cell-ml-model-repository-api.specs.file-info :refer :all]
            [cell-ml-model-repository-api.specs.exposure-file :refer :all]
            [cell-ml-model-repository-api.specs.repository-info :refer :all]
            [cell-ml-model-repository-api.specs.exposure-curation :refer :all]
            [cell-ml-model-repository-api.specs.exposure-file-summary :refer :all]
            [cell-ml-model-repository-api.specs.search-repository-200-response :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-cellml-main-with-http-info any?
  "CellML repository main page
  Get the main CellML page and repository information"
  []
  (call-api "/cellml" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/html" "application/json"]
             :auth-names    []}))

(defn-spec get-cellml-main string?
  "CellML repository main page
  Get the main CellML page and repository information"
  []
  (let [res (:data (get-cellml-main-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec get-exposure-with-http-info any?
  "Get exposure details
  Retrieve detailed information about a specific exposure"
  [exposure_id string?]
  (check-required-params exposure_id)
  (call-api "/exposure/{exposure_id}" :get
            {:path-params   {"exposure_id" exposure_id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/html" "application/json"]
             :auth-names    []}))

(defn-spec get-exposure string?
  "Get exposure details
  Retrieve detailed information about a specific exposure"
  [exposure_id string?]
  (let [res (:data (get-exposure-with-http-info exposure_id))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec get-exposure-file-with-http-info any?
  "Get exposure file
  Retrieve a specific file from an exposure"
  [exposure_id string?, file_path string?]
  (check-required-params exposure_id file_path)
  (call-api "/exposure/{exposure_id}/{file_path}" :get
            {:path-params   {"exposure_id" exposure_id "file_path" file_path }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/html" "application/json" "application/cellml+xml" "application/xml"]
             :auth-names    []}))

(defn-spec get-exposure-file string?
  "Get exposure file
  Retrieve a specific file from an exposure"
  [exposure_id string?, file_path string?]
  (let [res (:data (get-exposure-file-with-http-info exposure_id file_path))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec get-workspace-with-http-info any?
  "Get workspace details
  Retrieve detailed information about a specific workspace"
  [workspace_id string?]
  (check-required-params workspace_id)
  (call-api "/workspace/{workspace_id}" :get
            {:path-params   {"workspace_id" workspace_id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/html" "application/json"]
             :auth-names    []}))

(defn-spec get-workspace string?
  "Get workspace details
  Retrieve detailed information about a specific workspace"
  [workspace_id string?]
  (let [res (:data (get-workspace-with-http-info workspace_id))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec get-workspace-file-with-http-info any?
  "Get file from workspace
  Retrieve a specific file from a workspace at a given commit"
  [workspace_id string?, commit_id string?, filepath string?]
  (check-required-params workspace_id commit_id filepath)
  (call-api "/workspace/{workspace_id}/file/{commit_id}/{filepath}" :get
            {:path-params   {"workspace_id" workspace_id "commit_id" commit_id "filepath" filepath }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["*/*"]
             :auth-names    []}))

(defn-spec get-workspace-file string?
  "Get file from workspace
  Retrieve a specific file from a workspace at a given commit"
  [workspace_id string?, commit_id string?, filepath string?]
  (let [res (:data (get-workspace-file-with-http-info workspace_id commit_id filepath))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec get-workspace-raw-file-with-http-info any?
  "Get raw file content
  Retrieve the raw content of a file without any processing"
  [workspace_id string?, commit_id string?, filepath string?]
  (check-required-params workspace_id commit_id filepath)
  (call-api "/workspace/{workspace_id}/rawfile/{commit_id}/{filepath}" :get
            {:path-params   {"workspace_id" workspace_id "commit_id" commit_id "filepath" filepath }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["*/*"]
             :auth-names    []}))

(defn-spec get-workspace-raw-file any?
  "Get raw file content
  Retrieve the raw content of a file without any processing"
  [workspace_id string?, commit_id string?, filepath string?]
  (let [res (:data (get-workspace-raw-file-with-http-info workspace_id commit_id filepath))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec list-exposures-with-http-info any?
  "List all exposures
  Retrieve a list of all exposures (published models) in the repository"
  []
  (call-api "/exposure" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/html" "application/json"]
             :auth-names    []}))

(defn-spec list-exposures string?
  "List all exposures
  Retrieve a list of all exposures (published models) in the repository"
  []
  (let [res (:data (list-exposures-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec list-workspaces-with-http-info any?
  "List all workspaces
  Retrieve a list of all workspaces in the repository"
  []
  (call-api "/workspace" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/html" "application/json"]
             :auth-names    []}))

(defn-spec list-workspaces string?
  "List all workspaces
  Retrieve a list of all workspaces in the repository"
  []
  (let [res (:data (list-workspaces-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec search-repository-with-http-info any?
  "Search the repository
  Search for workspaces, exposures, and files in the repository.
Supports full-text search across all indexed content."
  ([] (search-repository-with-http-info nil))
  ([{:keys [SearchableText portal_type Subject b_start b_size]} (s/map-of keyword? any?)]
   (call-api "/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"SearchableText" SearchableText "portal_type" portal_type "Subject" Subject "b_start" b_start "b_size" b_size }
              :form-params   {}
              :content-types []
              :accepts       ["text/html" "application/json"]
              :auth-names    []})))

(defn-spec search-repository string?
  "Search the repository
  Search for workspaces, exposures, and files in the repository.
Supports full-text search across all indexed content."
  ([] (search-repository nil))
  ([optional-params any?]
   (let [res (:data (search-repository-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode string? res st/string-transformer)
        res))))



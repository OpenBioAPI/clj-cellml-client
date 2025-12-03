(defproject cell-ml-model-repository-api "1.0.0"
  :description "The CellML Model Repository provides a web service API for accessing 
CellML models stored in the repository. This API allows programmatic 
access to workspaces, exposures, and files within the repository.

The repository uses the Auckland Physiome Repository software (PMR2).

__Documentation:__ https://aucklandphysiomerepository.readthedocs.io/en/latest/webservice.html"
  :url "https://models.cellml.org"
  :license {:name "Apache 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [metosin/spec-tools "0.7.0"]
                 [clj-http "3.8.0"]
                 [orchestra "2017.11.12-1"]
                 [cheshire "5.8.0"]])
(defproject clojure-battleship "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 ; Compojure- a basic routing library
                 [compojure "1.6.1"]
                 ; http server for clojure
                 [http-kit "2.3.0"]
                 ;ring defaults
                 [ring/ring-defaults "0.3.2"]
                 ;clojure data JSON library
                 [org.clojure/data.json "0.2.6"]
                 ]
  :main ^:skip-aot clojure-battleship.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

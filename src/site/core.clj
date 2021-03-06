(ns site.core
  (:require [esthatic.core :as es]
            [gardner.core :as g]
            [garden.stylesheet :as gs]
            [garden.units :as gu]
            [endophile.core :as ec ]
            [clojure.java.io :as io]
            [endophile.hiccup :as  eh]
            [garden.units :as gu]
            [dali.io :as dali]))

(defn try-in-cloud []
  [:div.try
   [:$style 
    [:.try
     [:.moto-btn {:$color [:white :blue]
                  :$push-top 1
                  :vertical-align "baselin"
                  :font-family "'Gotham', Arial, sans-serif"
                  :$text [1 1 :uppercase :baseline]
                  :box-shadow "0 2px 5px rgba(0,0,0,0.5)"
                  :border-radius "30px"
                  :$padding [1 3]}
      [:&:hover {:$bg-color :light-blue}] ]
     [:.or {:$text 0.8 :$color :gray :$margin [0 1]}]
     [:.license {:$color :blue 
                 :$text 1 
                 :$border [:bottom :dashed 1 :blue]
                 :padding-bottom "4px" }
      [:&:hover {:text-decoration "none" 
                 :$border [:bottom :solid 1 :blue]}] ]]]

   [:$media {:max-width "480px"}
    [:.btn-wrap {:display "block"}] ]

   [:span.btn-wrap 
    [:a.btn.moto-btn {:href "https://aidbox.io/ui#/signup"} "TRY IN CLOUD"]]
   [:span.or " or "]
   [:a.license {:href "https://aidbox.io/ui"} "Request Enterprise License"] ])

(defn navigation [{data :data :as opts}]
  [:div#navigation

   [:$style
    [:#navigation {:position "relative"
                   :$padding [1.5 0 1.5 0]
                   :margin 0
                   :$color [:blue :bereza]}
     [:.desctop {:$flex-row [:baseline :space-between]}]   
     [:.navbar-header {:$flex-row [:center :space-between]}]   
     [:.icon-bar {:$bg-color :gray}]
     [:.brand {:$flex-full  true}
      [:a {:text-transform "uppercase" :$color :white :$text [1.5 1.5 :uppercase] }
       [:&:hover {:text-decoration "none"}]] ]
     [:ul {:margin-bottom 0}
      [:li [:a {:$color :blue
                :$text [1 2]
                :$padding 1}]]]
     [:.sign-in {:$color :blue
                 :$border [:solid 2  :blue] 
                 :$push-left 1
                 :$padding [0.3 2.2] 
                 :border-radius "20px"}] ]]
   [:$media {:min-width "479px"}
    [:#navigation
     [:.mobile {:display "none"}] ]]

   [:$media {:max-width "480px"}
    [:#navigation {:padding "15px 0 0"}
     [:.brand {:padding-left "15px"}]
     [:ul {:margin-bottom "10px" :display "none"}]
     [(keyword "#group:checked + ul") {:display "block !important"}]
     [:.sign-in {:margin-left "10px"}]
     [:.desctop {:display "none"}]
     [:.sign-in-li-item {:margin-top "10px"}]
     [:li {:width "100%"}] ] ]

   [:div.container.navigation.desctop
     [:div.brand
      [:a {:href "/index"} (get-in data [:text :title])]]
    [:ul.list-inline
     (for [x (data :menu)]
       [:li [:a {:href (es/url (:href x))} (:title x)]])]
    [:a.sign-in {:href "https://aidbox.io/ui"} "SIGN IN"] ]
   
   [:div.container.navigation.mobile
    [:.navbar-header
     [:div.brand
      [:a {:href "/index"} (get-in data [:text :title])]] 
     [:label {:for "group"}
      [:div.navbar-toggle
       [:span {:class "sr-only"} "Toggle navigation"]
       [:span {:class "icon-bar"}]
       [:span {:class "icon-bar"}]
       [:span {:class "icon-bar"}]] ] ]
    [:input#group.hidden {:type "checkbox"}]
    [:ul.list-inline
     (for [x (data :menu)]
       [:li [:a {:href (es/url (:href x))} (:title x)]])
     [:li.sign-in-li-item
      [:a.sign-in {:href "https://aidbox.io/ui"} "SIGN IN"]]]]
   ])

(defn layout [{data :data :as opts} cnt]
  [:html
   [:head
    [:meta {:name "viewport" :content "initial-scale=1, maximum-scale=1"}]
    [:$cdn-css :bootsrtrap]
    [:$google-font :Exo-2]
    [:$style
     [:body {:font-family "'Exo 2'"}]]]
   [:body
    (navigation opts)
    cnt]])

(defn features [{data :data :as opts}]
  [:div#index
   [:$style
    [:#index
     [:.box {:$padding 0}
      [:h3 {:$text [1.5 2 :normal :uppercase]}]
      [:p {:$text [1.2 2 200]
           :$color :text-muted}]]]]
   (for [feat (get-in data [:feature])]
     [:div.box
      [:div.container
       [:div.row
        [:.col-md-8
         [:h3 (:title feat)]
         [:p [:$md  (:text feat)]]]
        [:.col-md-4 [:img.img {:src (:img feat)}]]]]])])

(defn draw []
  [:div
   [:$style
    [:rect {:fill "#f1f1f1"}]]
   [:svg.logo {:width 120 :height 120 :viewBox "0 0 120 120"}
    [:rect {:x 10 :y 10 :width 100 :height 100 :rx 12 :ry 15}]]])

(defn moto [{data :data :as opts}]
  [:div#moto
   [:$style
    [:#moto
     {:$color [:text :bereza] 
      :background (str "#B4E1DA url('" (es/url "imgs" "background_cloud.png" ) "') 100% 160% no-repeat")
      :$push-bottom 2.5
      :position "relative" }
     [:.molecule {:position "absolute" :right "70px" :bottom "25px"}]
     [:h1 {:$text [1.5 2 300] :$push-bottom 1}]
     [:.moto {:$padding [5 30 5 0] :$height 30.5}]
     [:.banner {:$height 30}]
     [:.chevron {:position "absolute" :bottom "10px" :right "50%"}]
     [:p {:color "#555" :$text [1 1.5 200] :$width 56}]]]
   [:$media {:max-width "750px"}
    [:#moto 
     [:.molecule {:width "266px" :right "5%" :bottom 0}]
     [:.chevron {:display "none"}]
     [:.try {:text-align  "center"}]
     [:.moto {:height "auto" :padding 0 :padding-bottom "310px"}]
     [:p {:width "auto"}]] 
    ]

   [:$media {:min-width "750px" :max-width "1020px"}
    [:#moto
    [:.moto {:padding 0}]
    [:.chevron {:display "none"}]
    [:.molecule {:width "280px"}]]]
   [:div.container
    [:div.moto
     [:h1 (get-in data [:text :moto :subheader])]
     [:p  (get-in data [:text :moto :text])]
     [:img.molecule {:src (es/url "imgs" "molecule.png")}]
     [:img.chevron {:src (es/url "imgs" "chevron.png")}]
     (try-in-cloud)
     ]]])

(defn scenario [{data :data :as opts}]
  [:div#scenario
   [:$style
    [:#index
     [:.box {:$padding [2 0 3]}
      [:h3 {:$text [1.5 3 :normal :uppercase]}]
      [:p {:$text [1.2 2 200]
           :$color :text-muted}]
      [:.img {:width "70%" :display "block"
              :margin-left "auto"
              :margin-right "auto"
              :$push-top 4}]]]]

   [:$media {:max-width "480px"}
    [:#index [:.box {:padding 0}]] ]

   (for [[idx feat] (map-indexed (fn [x y] [x y]) (get-in data [:scenarios]))]
     [:div.box
      [:div.container
       (let [txt [:div [:h3 (:title feat)]
                  [:p [:$md  (:text feat)]]]
             img [:div [:img.img {:src (es/url "imgs" (:img feat))}]]]
         (if (even? idx)
           [:div.row 
            [:div.col-sm-6.col-sm-push-6 img] 
            [:div.col-sm-6.col-sm-pull-6 txt]]
           [:div.row 
            [:div.col-sm-6 img] 
            [:div.col-sm-6 txt] ]
           ))]])])

(defn footer [{data :data :as opts}]
  [:div#footer
   
   [:$style
    [:#footer {:$bg-color :bereza :$height 20 :text-align "center"
               :$padding [3 0] }
  
     [:.footer-container {:$width 40 :text-align "center" :margin "0 auto"}]
     [:p {:$text 1 :$color :gray :$push-bottom 0.5}]
     [:h2 {:$color :blue}] 
     [:.try {:text-align "center" :margin "0 auto" :$width 26}
      [:.btn-wrap {:display "block"}]
      [:.btn {:$push-bottom 0.5} ] ] ] ] 
   
   [:$media {:max-width "400px"}
      [:#footer [:.footer-container {:width "75%" :margin "0 auto"}]]]

   [:div.footer-container
    [:h2 (get-in data [:text :footer :header])]
    [:p (get-in data [:text :footer :text])]
    (try-in-cloud)] ])

(defn index [{data :data :as opts}]
  [:div#index
   (moto opts)
   (scenario opts)
   (footer opts) ])

(defn basename [name]
  (get (re-find #"(.+?).md$" name) 1))

(defn docs-pages []
  (let [dir (io/file (io/resource "docs"))
        files (filter #(re-matches #"(.+?).md$" (.getName %))
                (rest (file-seq dir))) ]
    (mapv #(basename (.getName %)) files)))

(defn docs [{{id :id} :params data :data :as opts}]
  [:div.container
   [:div.row
    [:nav#submenu.col-sm-2
     [:$style [:#submenu {:$push-top 1}] ]
     [:ul.nav
      (for [i (:docs data)] ^{:key (basename (:file i))}
        [:li [:a {:href (es/url "docs" (basename (:file i)))} (:title i)]])]] 
    [:div.col-sm-10
     [:$style [:code {:white-space "pre" :display "block"} ] ]
     [:div.markdown
      (eh/to-hiccup (ec/mp (slurp (io/resource (str "docs/" id ".md")))))]] ]])


(def routes
  {:GET #'index
   "features" {:GET #'features}
   "docs" {:GEET #'docs
           [:id] {:GET #'docs}
           :id docs-pages }
   "index" {:GET #'index}})

(def styles
  {:vars {:v 18
          :h 10
          :g 300}
   :macros {}
   :colors {:gray "#474747"
            :text "#192F3D"
            :bereza-text "#49645F"
            :bereza "#B4E1DA"
            :blue "#2B4961"
            :light-blue "#406E93"
            :white "#fff"
            :text-yellow "#FDCD00"
            :text-muted "#47525d"
            :btn-gray "#424952"
            :black "black"
            :transparent "transparent"}})

(def config {:routes #'routes
             :styles #'styles
             :layout #'layout})

(defn -main [] (es/generate config))

(comment
  (def stop (es/start config))
  (es/generate (assoc config :prefix "site/"))
  (stop))

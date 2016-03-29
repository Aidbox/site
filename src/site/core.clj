(ns site.core
  (:require [esthatic.core :as es]))

(defn navigation [{data :data :as opts}]
  [:div#navigation
   [:$style
    [:#navigation
     {:position "relative" :$margin [1 0]}
     [:a.brand {:text-transform "uppercase"}]
     [:ul {:margin-bottom 0 :float "right"}
      [:li [:a {:text-transform "uppercase"
                :$padding 1}]]]]]
   [:div.container
    [:a.brand {:href "index"} "[a]idbox"]
    [:ul.list-inline
     (for [x (data :menu)]
       [:li [:a {:href (:href x)} (:title x)]])]]])


(defn layout [{data :data :as opts} cnt]
  [:html
   [:head
    [:$cdn-css :bootsrtrap]
    [:$google-font :Exo-2]
    [:$style
     [:body {:font-family "'Exo 2'"}]]]
   [:body
    (navigation opts)
    cnt]])


(defn index [{data :data :as opts}]
  [:div#index
   [:$style
    [:#index
     [:.moto
      {:$padding [4 0]}
      [:h1 {:font-weight 300 :margin-bottom "1em"}]
      [:p {:color "#555"
           :$text [1 2]}]]
     [:.box {:$padding [2 0]
             :background-color "#f1f1f1"}
      [:h3 {:text-transform "uppercase"
            :$text [1.5 3 "normal"]}]
      [:p {:$text [1.2 2 "normal"]}]
      [:.img {:width "100%"}]
      [:.clr {:clear "both"}]]]]

   [:div.moto
    [:div.container
     [:div.col-md-8
      [:h1 (get-in data [:text :moto :subheader])]
      [:p  (get-in data [:text :moto :text])]
      [:br]
      [:button.btn.btn-lg.btn-success "Try in Our Cloud"]
      " "
      [:button.btn.btn-lg.btn-primary "Enterprise Version"]]
     [:div.col-md-4
      [:img {:style "width: 100%"
             :src "http://thumbs.dreamstime.com/z/bright-simple-graphic-illustration-trendy-flat-style-colors-sliding-door-wardrobe-use-design-vector-51410228.jpg"}]]]]

   (for [feat (get-in data [:features])]
     [:div.box
      [:div.container
       [:div.row
        [:.col-md-8
         [:h3 (:title feat)]
         [:p [:$md  (:text feat)]]]
        [:.col-md-4 [:img.img {:src (:img feat)}]]]]])])

(def routes
  {:GET #'index
   "index" {:GET #'index}})

(def styles
  {:vars {:v 18
          :h 10
          :g 300}
   :macros {}
   :colors {:gray "#777"
            :black "black"
            :transparent "transparent"}})

(def config {:routes #'routes
             :styles #'styles
             :layout #'layout})

(comment
  (def stop (es/start config))
  (es/generate config)
  (stop))

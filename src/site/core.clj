(ns site.core
  (:require [esthatic.core :as es]
            [dali.io :as dali]))

(defn navigation [{data :data :as opts}]
  [:div#navigation
   [:$style
    [:#navigation {:position "relative"
                   :$padding [3.5 0 0 0]
                   :margin 0
                   :$color [:blue :bereza]}
     [:a.brand {:text-transform "uppercase" :$color :white :$text [1.5 2 :uppercase] }
      [:&:hover {:text-decoration "none"}] ]
     [:ul {:margin-bottom 0 :float "right"}
      [:li [:a {:text-transform "uppercase"
                :$color :blue
                :$padding 1}]]]]]
   [:div.container
    [:a.brand {:href "index"} (get-in data [:text :title])]
    [:ul.list-inline
     (for [x (data :menu)]
       [:li [:a {:href (es/url (:href x))} (:title x)]])]]])


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
     {:$color [:text :bereza] :background (str "#B4E1DA url('" (es/url "imgs" "background_cloud.png" ) "') bottom right no-repeat")}
     [:h1 {:$text [2 3 300] :$push-bottom 1}]
     [:.moto {:$padding [6.5 30 5 0]}]
     [:.moto-btn {:$color [:white :blue]
                  :$push-top 1.5
                  :vertical-align "baselin"
                  :font-family "'Gotham', Arial, sans-serif"
                  :$text [1 1.5 :uppercase :baseline]
                  :box-shadow "0 2px 5px rgba(0,0,0,0.5)"
                  :border-radius "30px"
                  :$padding [1 4]}]
     [:.banner {:$height 30}]
     [:p {:color "#555" :$text [1 1.5 200] :$width 56}]]]
   [:div.container
    [:div.moto
     [:h1 (get-in data [:text :moto :subheader])]
     [:p  (get-in data [:text :moto :text])]
     [:button.btn.moto-btn "Try in Our Cloud"]]]])

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

   (for [[idx feat] (map-indexed (fn [x y] [x y]) (get-in data [:scenarios]))]
     [:div.box
      [:div.container
       (let [txt [:.col-md-6 [:h3 (:title feat)]
                  [:p [:$md  (:text feat)]]]
             img [:.col-md-6 [:img.img {:src (es/url "imgs" (:img feat))}]]]
         (if (even? idx)
           [:div.row txt img]
           [:div.row img txt]))]])])

(defn index [{data :data :as opts}]
  [:div#index
   (moto opts)
   (scenario opts)])

(def routes
  {:GET #'index
   "features" {:GET #'features}
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

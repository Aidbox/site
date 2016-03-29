(ns site.navigation
  (:require [site.routes :refer [url]]
            [site.data :refer [data i idata] :as d]
            [site.font :refer [icon]]
            [site.styles :refer [s-var style vh undecorate pbox mbox] :as s]
            [site.widgets :refer [grid]]))


(defn navigation [opts]
  (let [props (merge {:color :inverse} opts)
        uri (get-in opts [:request :uri])]
    [:div#navigation
     (style
      [:#navigation
       {:position "relative"}
       (s/&margin 1 0 1 0)
       [:a.brand 
        {:text-transform "uppercase"}
        (s/&unstyle-links)
        (s/&font-scale 1 3)
        (s/&padding 0.5 1)
        (s/&inline)
        (s/&text :center)]
       [:ul {:margin-bottom 0 :float "right"}
        (s/&inline)
        [:li (s/&inline)
         [:a {:text-transform "uppercase"}
          (s/&font-scale 1 3)
          (s/&padding 0.5 1)
          (s/&inline)
          (undecorate)
          [:&:hover {:color "red" 
                     :border-color "blue"}]]]]])
     [:div.container
      [:a.brand {:href (url "index")} "[a]idbox"]
      [:ul.list-inline
       (for [x (data :menu)]
         [:li [:a {:href (url (:href x))} (i x :title)]])]]]))


(defn footer-title [href k]
  [:a {:href (url href)} [:h4 (idata :text k)]])

(defn footer []
  [:div#footer
   (style
    [:div#footer
     (s-var :color :inverse-ex :text)
     (s/&padding 4 nil 0 nil)
     [:a {:color "#ddd"}]
     [:.footer-line {:background "rgba(46,48,58,1)"}
      (s/&text :center)
      (s/&margin 2 0 0 0)
      (s/&padding 1 0)]
     [:li (s/&margin 0.5 0)]])
   [:div.container
    (grid
     [(footer-title "products" :products)
      [:ul.list-unstyled]]

     [(footer-title "services" :development)
      [:ul.list-unstyled]]

     [(footer-title "trainings" :education)
      [:ul.list-unstyled]]

     [(footer-title "contacts" :contacts)
      [:ul.list-unstyled]])]

   [:div.footer-line
    [:div.container-fluid
     [:span  " © 2015 HealthSamurai " (icon :samurai)]]]])

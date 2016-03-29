(ns site.index
  (:require [site.styles :refer [style vh s-var undecorate] :as s]
            [garden.units :refer [px px*]]
            [site.widgets :refer [splash grid] :as w]
            [site.routes :refer [url]]
            [site.formats :as fmt]
            [site.data :refer [data i idata md]]
            [site.font :as font]
            [site.navigation :refer [navigation]]))

(defn what []
  [:div
   (style [:#promo (s/&margin 1 0 100 0)
           [:i.aidbox [:svg {:height "30px"}]]
           [:.box {:margin "0 0px 20px 0"
                   :background-color "#ebebeb"
                   :height "200px"
                   :padding "20px 30px"}
            [:h3 {:font-size "18px"}]]
           [:#moto {:background "white"
                    :height "420px"}
            (s/&padding 4 3)]])
   [:div#promo
    [:div.container
     [:div.col-md-6
      [:div#moto
       [:i.aidbox  (s/svg :aidbox)]
       [:h1 "AIDBOX"]
       [:p
        "backend and frontend"
        [:br]
        "for healthcare apps"]]]
     [:div.col-md-6
      [:div.row
       [:div.col-md-6
        [:div.box
         [:h3 "Data"]
         [:ul
          [:li "Storage"]
          [:li "Analytic"]
          [:li "PostgreSQL"]]]]
       [:div.col-md-6
        [:div.box
         [:h3 "Interaction"]
         [:ul
          [:li "FHIR REST API"]
          [:li "HL7v2, CDA"]
          [:li "SDK"]]]]]
      [:div.row
       [:div.col-md-6
        [:div.box
         [:h3 "Security"]
         [:ul
          [:li "OAuth 2"]
          [:li "Access Control"]
          [:li "Audit"]
          [:li "HIPPA"]]]]
       [:div.col-md-6
        [:div.box
         [:h3 "Cloud"]
         [:ul
          [:li "Private"]
          [:li "Updates"]
          [:li "Provisioning"]]]]]]]]])

(defn block [& args]
  (into [:div.box] args))

(defn index [req]
  [:div#index
   (navigation {:color :main :request req})
   (style
    [:#index
     [:.moto
      {:padding "10em 0 10em"}
      [:h1 {:font-weight 300 :margin-bottom "1em"}]
      [:p {:color "#555"
           :font-size "18px"
           :line-height "2em"}]]
     [:.box {:padding "3em 0"
             :background-color "#f1f1f1"}
      [:h3 {:text-transform "uppercase" :font-size "30px" :font-weight "normal" :line-height "3em"}]
      [:p {:line-height "2em" :font-size "1.2em"}]
      [:.img {:margin "0 1em" :float "right" :height "200px"}]
      [:.clr {:clear "both"}]]])

   [:div
    [:div.moto
     [:div.container
      [:div.col-md-8
       [:h1 (data :text :moto :subheader)]
       [:p  (data  :text :moto :text)]
       [:br]
       [:button.btn.btn-lg.btn-success "Try in Our Cloud"]
       " "
       [:button.btn.btn-lg.btn-primary "Enterprise Version"]]
      [:div.col-md-4
       [:img {:style "width: 100%"
              :src "http://thumbs.dreamstime.com/z/bright-simple-graphic-illustration-trendy-flat-style-colors-sliding-door-wardrobe-use-design-vector-51410228.jpg"}]]]
     ]

    (for [feat (data :features)]
      [:div.box
       [:div.container
        [:h3 (:title feat)]
        [:img.img {:src (:img feat)}]
        [:p (fmt/markdown (:text feat))]]
       [:div.clr]])
    
    (block
     [:h2 "Features"]
     [:div
      [:hr]
      [:ul
       [:li "Data & Analysis"]
       [:li "Security"]
       [:li "Integrations & API"]
       [:li "Cloud"]
       [:li "SDK"]]])

    (block
     [:h2 "Risks"]
     [:div
      [:hr]
      [:ul
       [:li "Clients"]
       [:li "Licenses"]
       [:li "Architecture (Scalability)"]]])

    (block
     [:h2 "Call to action"]
     [:ul
      [:li "trial cloud (try now)"]
      [:li "contact (about demo and details)"]])]])

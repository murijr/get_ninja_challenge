package br.com.mandy.getninjachallenge.data.entity.offerdetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OfferDetail {
    @SerializedName("distance")
    @Expose
    var distance: Int? = null
    @SerializedName("lead_price")
    @Expose
    var leadPrice: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("_embedded")
    @Expose
    var embedded: Embedded? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}
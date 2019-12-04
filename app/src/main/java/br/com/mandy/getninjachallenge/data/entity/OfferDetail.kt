package br.com.mandy.getninjachallenge.data.entity

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
    @SerializedName("_embeddedOfferDetail")
    @Expose
    var embeddedOfferDetail: EmbeddedOfferDetail? = null
    @SerializedName("_linksOfferDetail")
    @Expose
    var linksOfferDetail: LinksOfferDetail? = null

}
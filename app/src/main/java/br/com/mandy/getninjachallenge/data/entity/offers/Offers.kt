package br.com.mandy.getninjachallenge.data.entity.offers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Offers {
    @SerializedName("offers")
    @Expose
    var offers: List<Offer>? = null
    @SerializedName("_links")
    @Expose
    var links: Links_? = null

}
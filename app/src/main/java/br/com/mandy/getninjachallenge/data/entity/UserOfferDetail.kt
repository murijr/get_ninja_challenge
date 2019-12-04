package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserOfferDetail {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("_embeddedUserOfferDetail")
    @Expose
    var embeddedUserOfferDetail: EmbeddedUserOfferDetail? = null

}
package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EmbeddedOfferDetail {
    @SerializedName("info")
    @Expose
    var info: List<Info>? = null
    @SerializedName("userOfferDetail")
    @Expose
    var userOfferDetail: UserOfferDetail? = null
    @SerializedName("addressOfferDetail")
    @Expose
    var addressOfferDetail: AddressOfferDetail? = null

}
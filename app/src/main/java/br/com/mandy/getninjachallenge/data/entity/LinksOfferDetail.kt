package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LinksOfferDetail {
    @SerializedName("acceptLinksOfferDetail")
    @Expose
    var acceptLinksOfferDetail: AcceptLinksOfferDetail? = null
    @SerializedName("rejectLinksOfferDetail")
    @Expose
    var rejectLinksOfferDetail: RejectLinksOfferDetail? = null

}
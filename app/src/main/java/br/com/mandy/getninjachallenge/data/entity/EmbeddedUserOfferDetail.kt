package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EmbeddedUserOfferDetail {
    @SerializedName("phones")
    @Expose
    var phones: List<Phone>? = null

}
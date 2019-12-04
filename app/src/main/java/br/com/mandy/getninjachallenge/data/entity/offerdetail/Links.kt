package br.com.mandy.getninjachallenge.data.entity.offerdetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {
    @SerializedName("accept")
    @Expose
    var accept: Accept? = null
    @SerializedName("reject")
    @Expose
    var reject: Reject? = null

}
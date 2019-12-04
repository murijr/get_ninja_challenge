package br.com.mandy.getninjachallenge.data.entity.offerdetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Embedded {
    @SerializedName("info")
    @Expose
    var info: List<Info>? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("address")
    @Expose
    var address: Address? = null

}
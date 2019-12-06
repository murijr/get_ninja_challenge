package br.com.mandy.getninjachallenge.data.entity.leads

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Embedded {
    @SerializedName("address")
    @Expose
    var address: Address? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("request")
    @Expose
    var request: Request? = null

}
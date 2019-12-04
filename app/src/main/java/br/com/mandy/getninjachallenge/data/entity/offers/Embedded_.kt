package br.com.mandy.getninjachallenge.data.entity.offers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Embedded_ {
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("address")
    @Expose
    var address: Address? = null

}
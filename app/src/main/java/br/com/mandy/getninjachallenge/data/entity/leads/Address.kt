package br.com.mandy.getninjachallenge.data.entity.leads

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("street")
    @Expose
    var street: String? = null
    @SerializedName("neighborhood")
    @Expose
    var neighborhood: String? = null
    @SerializedName("uf")
    @Expose
    var uf: String? = null

}
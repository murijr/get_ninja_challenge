package br.com.mandy.getninjachallenge.data.entity.offerdetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("_embedded")
    @Expose
    var embedded: Embedded_? = null

}
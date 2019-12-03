package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Offer {
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("_embedded")
    @Expose
    var embedded: Embedded? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}
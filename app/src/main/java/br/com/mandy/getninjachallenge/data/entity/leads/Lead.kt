package br.com.mandy.getninjachallenge.data.entity.leads

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Lead {
    @SerializedName("created_at")
    @Expose
    var createdAt: Date? = null
    @SerializedName("_embedded")
    @Expose
    var embedded: Embedded? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}
package br.com.mandy.getninjachallenge.data.entity.leads

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Leads {
    @SerializedName("leads")
    @Expose
    var leads: List<Lead>? = null
    @SerializedName("_links")
    @Expose
    var links: Links_? = null

}
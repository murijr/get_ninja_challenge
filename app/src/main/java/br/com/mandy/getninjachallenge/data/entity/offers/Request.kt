package br.com.mandy.getninjachallenge.data.entity.offers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Request {
    @SerializedName("created_at")
    @Expose
    var createdAt: Date? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("_embedded")
    @Expose
    var embedded: Embedded_? = null

}
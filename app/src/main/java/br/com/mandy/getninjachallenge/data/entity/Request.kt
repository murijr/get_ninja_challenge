package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Request {
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("_embedded")
    @Expose
    var embedded: Embedded_? = null

}
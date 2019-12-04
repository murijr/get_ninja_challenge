package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Info {
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("value")
    @Expose
    var value: String? = null

}
package br.com.mandy.getninjachallenge.data.entity.offers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Embedded {
    @SerializedName("request")
    @Expose
    var request: Request? = null

}
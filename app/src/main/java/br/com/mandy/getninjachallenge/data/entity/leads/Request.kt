package br.com.mandy.getninjachallenge.data.entity.leads

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Request {
    @SerializedName("title")
    @Expose
    var title: String? = null

}
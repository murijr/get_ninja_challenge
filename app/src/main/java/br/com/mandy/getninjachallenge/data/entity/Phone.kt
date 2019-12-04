package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Phone {
    @SerializedName("number")
    @Expose
    var number: String? = null

}
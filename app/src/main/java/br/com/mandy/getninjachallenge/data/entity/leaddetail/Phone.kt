package br.com.mandy.getninjachallenge.data.entity.leaddetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Phone {
    @SerializedName("number")
    @Expose
    var number: String? = null

}
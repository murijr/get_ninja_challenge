package br.com.mandy.getninjachallenge.data.entity.offers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {
    @SerializedName("self")
    @Expose
    var self: Self? = null

}
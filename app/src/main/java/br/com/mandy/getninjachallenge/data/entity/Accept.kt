package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Accept {
    @SerializedName("href")
    @Expose
    var href: String? = null

}
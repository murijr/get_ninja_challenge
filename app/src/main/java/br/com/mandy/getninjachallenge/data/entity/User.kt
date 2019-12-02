package br.com.mandy.getninjachallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("name")
    @Expose
    var name: String? = null

}
package br.com.mandy.getninjachallenge.data.entity.leaddetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geolocation {
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null

}
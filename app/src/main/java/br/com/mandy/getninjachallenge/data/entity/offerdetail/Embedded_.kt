package br.com.mandy.getninjachallenge.data.entity.offerdetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Embedded_ {
    @SerializedName("phones")
    @Expose
    var phones: List<Phone>? = null

}
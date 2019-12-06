package br.com.mandy.getninjachallenge.data.entity.leaddetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Info {
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("value")
    @Expose
    var value: ArrayList<String>? = arrayListOf()

}
package br.com.mandy.getninjachallenge.common.converter

import br.com.mandy.getninjachallenge.data.entity.Offers
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.json.JSONObject

class OfferConverter(private val gson: Gson) {

    infix fun from(jsonObject: JSONObject?): Offers {
        val jsonString = jsonObject.toString()
        val json = JsonParser.parseString(jsonString)
        return gson.fromJson<Offers>(json, Offers::class.java)
    }
}
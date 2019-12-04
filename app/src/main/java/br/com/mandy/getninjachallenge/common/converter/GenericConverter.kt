package br.com.mandy.getninjachallenge.common.converter

import com.google.gson.Gson
import com.google.gson.JsonParser
import org.json.JSONObject

class GenericConverter(val gson: Gson) {

    inline fun <reified OUT> from(jsonObject: JSONObject?): OUT {
        val jsonString = jsonObject.toString()
        val json = JsonParser.parseString(jsonString)
        return this.gson.fromJson<OUT>(json, OUT::class.java) as OUT
    }
}
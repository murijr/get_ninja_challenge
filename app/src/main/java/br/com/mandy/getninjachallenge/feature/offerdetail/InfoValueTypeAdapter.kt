package br.com.mandy.getninjachallenge.feature.offerdetail

import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class InfoValueTypeAdapter: JsonDeserializer<Info> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Info {

        val valueField = (json as JsonObject).get("value")
        val labelField = json.get("label")

        return Info().also { info ->
            info.label = labelField.asString
            if (valueField.isJsonPrimitive) {
                info.value?.add(valueField.asString)
            } else {
                valueField.asJsonArray.forEach {
                    info.value?.add(it.asString)
                }
            }
        }
    }
}
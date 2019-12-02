package br.com.mandy.getninjachallenge.data.repository.offer

import br.com.mandy.getninjachallenge.common.converter.OfferConverter
import br.com.mandy.getninjachallenge.data.entity.Offers
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject


class OfferRemoteRepository(private val converter: OfferConverter): OfferRepository {

    override fun getOffers(onSuccess: ((Offers) -> Unit)?, onError: ((Throwable) -> Unit)?) {
        AndroidNetworking.get("http://testemobile.getninjas.com.br/offers")
            .setTag("getOffers")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    val offers = converter from response
                    onSuccess?.invoke(offers)
                }

                override fun onError(anError: ANError?) {
                    onError?.invoke(anError as Exception)
                }
            })
    }
}
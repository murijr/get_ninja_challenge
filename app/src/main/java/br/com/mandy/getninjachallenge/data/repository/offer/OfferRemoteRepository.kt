package br.com.mandy.getninjachallenge.data.repository.offer

import br.com.mandy.getninjachallenge.data.entity.Offer
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import org.json.JSONArray


class OfferRemoteRepository: OfferRepository {

    override fun getOffers(onSuccess: ((List<Offer>) -> Unit)?, onError: ((Throwable) -> Unit)?) {
        AndroidNetworking.get("http://testemobile.getninjas.com.br/offers")
            .setTag("getOffers")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    return
                }

                override fun onError(error: ANError) {
                    return
                }
            })
    }
}
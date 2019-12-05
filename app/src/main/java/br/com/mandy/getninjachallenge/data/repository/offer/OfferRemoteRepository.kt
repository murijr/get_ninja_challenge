package br.com.mandy.getninjachallenge.data.repository.offer

import br.com.mandy.getninjachallenge.common.converter.GenericConverter
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offers.Offers
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject


class OfferRemoteRepository(private val converter: GenericConverter): OfferRepository {

    override fun getOffers(onSuccess: ((Offers) -> Unit)?, onError: ((Throwable) -> Unit)?) {
        AndroidNetworking.get("https://testemobile.getninjas.com.br/offers")
            .setTag("getOffers")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    val offers = converter.from<Offers>(response)
                    onSuccess?.invoke(offers)
                }

                override fun onError(anError: ANError?) {
                    onError?.invoke(anError as Exception)
                }
            })
    }

    override fun getOffersDetail(
        offerDetailURL: String, onSuccess: ((OfferDetail) -> Unit)?, onError: ((Throwable) -> Unit)?) {

        AndroidNetworking.get(offerDetailURL)
            .setTag("getOfferDetail")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    val offerDetail = converter.from<OfferDetail>(response)
                    onSuccess?.invoke(offerDetail)
                }

                override fun onError(anError: ANError?) {
                    onError?.invoke(anError as Exception)
                }
            })
    }
}
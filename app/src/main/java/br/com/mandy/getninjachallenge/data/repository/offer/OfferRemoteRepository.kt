package br.com.mandy.getninjachallenge.data.repository.offer

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.common.LEADS_LIST_URL
import br.com.mandy.getninjachallenge.common.OFFERS_LIST_URL
import br.com.mandy.getninjachallenge.common.converter.GenericConverter
import br.com.mandy.getninjachallenge.data.entity.leads.Leads
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offers.Offers
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.squareup.picasso.Picasso
import org.json.JSONObject
import kotlin.concurrent.thread


class OfferRemoteRepository(private val converter: GenericConverter): OfferRepository {

    override fun getOffers(offerListUrl: String?, onSuccess: ((Offers) -> Unit)?, onError: ((Throwable) -> Unit)?) {
        AndroidNetworking.get(offerListUrl)
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

    override fun getOfferMap(
        geolocation: Geolocation?,
        onSuccess: ((Bitmap) -> Unit)?,
        onError: ((Throwable) -> Unit)?) {

        thread {
            val bitmap = Picasso.get()
                .load("https://maps.googleapis.com/maps/api/staticmap?" +
                        "size=600x300&markers=color:red%7Clabel:C%7C" +
                        "${geolocation?.latitude},${geolocation?.longitude}&" +
                        "key=AIzaSyB9Orb1AUnAmhxWSCbaODmM7ONI1tl7BoM")
                .get()
            onSuccess?.invoke(bitmap)
        }
    }
}
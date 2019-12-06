package br.com.mandy.getninjachallenge.data.repository.offer

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offers.Offers

interface OfferRepository {
    fun getOffers(
        onSuccess: ((Offers) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
    fun getOffersDetail(
        offerDetailURL: String, onSuccess: ((OfferDetail) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
    fun getOfferMap(
        geolocation: Geolocation?, onSuccess: ((Bitmap) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
}
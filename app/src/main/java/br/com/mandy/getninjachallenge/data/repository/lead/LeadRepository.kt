package br.com.mandy.getninjachallenge.data.repository.lead

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.data.entity.leads.Leads
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offers.Offers

interface LeadRepository {
    fun getLeads(
        onSuccess: ((Leads) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
    fun getLeadsDetail(
        offerDetailURL: String, onSuccess: ((OfferDetail) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
    fun getLeadMap(
        geolocation: Geolocation?, onSuccess: ((Bitmap) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
}
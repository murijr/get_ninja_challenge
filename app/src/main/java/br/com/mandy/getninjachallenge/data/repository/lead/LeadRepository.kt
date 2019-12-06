package br.com.mandy.getninjachallenge.data.repository.lead

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.data.entity.leaddetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.leaddetail.LeadDetail
import br.com.mandy.getninjachallenge.data.entity.leads.Leads

interface LeadRepository {
    fun getLeads(
        onSuccess: ((Leads) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
    fun getLeadsDetail(
        leadDetailURL: String, onSuccess: ((LeadDetail) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
    fun getLeadMap(
        geolocation: Geolocation?, onSuccess: ((Bitmap) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
}
package br.com.mandy.getninjachallenge.data.repository.lead

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.common.LEADS_LIST_URL
import br.com.mandy.getninjachallenge.common.converter.GenericConverter
import br.com.mandy.getninjachallenge.data.entity.leaddetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.leaddetail.LeadDetail
import br.com.mandy.getninjachallenge.data.entity.leads.Leads
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject


class LeadRemoteRepository(private val converter: GenericConverter):
    LeadRepository {

    override fun getLeads(onSuccess: ((Leads) -> Unit)?, onError: ((Throwable) -> Unit)?) {

        AndroidNetworking.get(LEADS_LIST_URL)
            .setTag("getLeads")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    val leads = converter.from<Leads>(response)
                    onSuccess?.invoke(leads)
                }

                override fun onError(anError: ANError?) {
                    onError?.invoke(anError as Exception)
                }
            })
    }

    override fun getLeadsDetail(
        leadDetailURL: String,
        onSuccess: ((LeadDetail) -> Unit)?,
        onError: ((Throwable) -> Unit)?
    ) {
    }

    override fun getLeadMap(
        geolocation: Geolocation?,
        onSuccess: ((Bitmap) -> Unit)?,
        onError: ((Throwable) -> Unit)?
    ) {
    }
}
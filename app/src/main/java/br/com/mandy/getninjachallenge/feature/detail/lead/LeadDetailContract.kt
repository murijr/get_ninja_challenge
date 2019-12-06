package br.com.mandy.getninjachallenge.feature.detail.lead

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.data.entity.leaddetail.LeadDetail
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail


interface LeadDetailContract {
    interface Presenter {
        fun takeView(leadDetailView: View)
        fun getLeadDetail(leadDetailURL: String)
    }

    interface View {
        fun showLeadDetail(leadDetail: LeadDetail)
        fun showLeadMap(map: Bitmap)
        fun showLeadDistance(distance: String)
    }
}
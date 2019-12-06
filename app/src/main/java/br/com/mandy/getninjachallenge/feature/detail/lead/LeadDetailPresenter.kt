package br.com.mandy.getninjachallenge.feature.detail.lead

import br.com.mandy.getninjachallenge.common.extension.distanceInkm
import br.com.mandy.getninjachallenge.data.entity.leaddetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.leaddetail.LeadDetail
import br.com.mandy.getninjachallenge.data.repository.lead.LeadRepository

class LeadDetailPresenter(private val leadRepository: LeadRepository,
                          private var view: LeadDetailContract.View? = null,
                          private var leadDetail: LeadDetail? = null): LeadDetailContract.Presenter {



    override fun takeView(leadDetailView: LeadDetailContract.View) {
        this.view = leadDetailView
    }

    override fun getLeadDetail(leadDetailURL: String) {
        leadRepository.getLeadsDetail(leadDetailURL, { leadDetail ->
            this.leadDetail = leadDetail
            this.view?.showLeadDetail(leadDetail)
            showMapAtView(leadDetail.embedded?.address?.geolocation)
            showDistanceAtView(leadDetail.distanceInkm)
        })
    }

    private fun showMapAtView(geolocation: Geolocation?) {
        leadRepository.getLeadMap(geolocation, { bitmap ->
            this.view?.showLeadMap(bitmap)
        })
    }

    private fun showDistanceAtView(distanceInkm: Int?) {
        this.view?.showLeadDistance(distanceInkm.toString())
    }
}
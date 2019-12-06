package br.com.mandy.getninjachallenge.feature.solicitation.lead

import br.com.mandy.getninjachallenge.data.repository.lead.LeadRepository

class LeadPresenter(private val leadRepository: LeadRepository,
                    private var view: LeadContract.View? = null): LeadContract.Presenter {

    override fun takeView(leadView: LeadContract.View) {
        this.view = leadView
    }

    override fun getLeads() {
        leadRepository.getLeads({
            view?.showLeads(it)
        })
    }
}
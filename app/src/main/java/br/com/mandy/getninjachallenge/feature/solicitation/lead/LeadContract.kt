package br.com.mandy.getninjachallenge.feature.solicitation.lead

import br.com.mandy.getninjachallenge.data.entity.leads.Leads

interface LeadContract {

    interface Presenter {
        fun takeView(leadView: View)
        fun getLeads()
    }

    interface View {
        fun showLeads(leads: Leads)
    }
}
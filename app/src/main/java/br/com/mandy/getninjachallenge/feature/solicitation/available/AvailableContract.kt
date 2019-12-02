package br.com.mandy.getninjachallenge.feature.solicitation.available

import br.com.mandy.getninjachallenge.data.entity.Offer

interface AvailableContract {

    interface Presenter {
        fun takeView(view: View)
        fun getOffers()
    }

    interface View {
        fun showOffers(offers: List<Offer>)
    }
}
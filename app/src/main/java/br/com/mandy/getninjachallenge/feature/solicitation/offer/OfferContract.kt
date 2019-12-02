package br.com.mandy.getninjachallenge.feature.solicitation.offer

import br.com.mandy.getninjachallenge.data.entity.Offer

interface OfferContract {

    interface Presenter {
        fun takeView(view: View)
        fun getOffers()
    }

    interface View {
        fun showOffers(offers: List<Offer>)
    }
}
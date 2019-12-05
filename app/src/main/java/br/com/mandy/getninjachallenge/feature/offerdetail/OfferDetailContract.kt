package br.com.mandy.getninjachallenge.feature.offerdetail

import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail


interface OfferDetailContract {
    interface Presenter {
        fun takeView(offerDetailView: View)
        fun getOfferDetail(offerDetailURL: String)
    }

    interface View {
        fun showOfferDetail(offerDetail: OfferDetail)
    }
}
package br.com.mandy.getninjachallenge.feature.offerdetail

import br.com.mandy.getninjachallenge.data.repository.offer.OfferRepository

class OfferDetailPresenter(private val offerRepository: OfferRepository,
                           private var view: OfferDetailContract.View? = null): OfferDetailContract.Presenter {

    override fun takeView(offerDetailView: OfferDetailContract.View) {
        this.view = offerDetailView
    }

    override fun getOfferDetail(offerDetailURL: String) {
    }
}
package br.com.mandy.getninjachallenge.feature.solicitation.offer

import br.com.mandy.getninjachallenge.data.repository.offer.OfferRepository

class OfferPresenter(private val offerRepository: OfferRepository,
                     private var view: OfferContract.View? = null): OfferContract.Presenter {

    override fun takeView(offerView: OfferContract.View) {
        this.view = offerView
    }

    override fun getOffers() {
        offerRepository.getOffers({
            view?.showOffers(it)
        })
    }
}
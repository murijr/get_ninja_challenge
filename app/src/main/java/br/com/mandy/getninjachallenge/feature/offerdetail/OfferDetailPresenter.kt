package br.com.mandy.getninjachallenge.feature.offerdetail

import br.com.mandy.getninjachallenge.data.entity.offerdetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.repository.offer.OfferRepository

class OfferDetailPresenter(private val offerRepository: OfferRepository,
                           private var view: OfferDetailContract.View? = null): OfferDetailContract.Presenter {

    override fun takeView(offerDetailView: OfferDetailContract.View) {
        this.view = offerDetailView
    }

    override fun getOfferDetail(offerDetailURL: String) {
        offerRepository.getOffersDetail(offerDetailURL, { offerDetail ->
            this.view?.showOfferDetail(offerDetail)
            showMapInView(offerDetail?.embedded?.address?.geolocation)
        })
    }

    private fun showMapInView(geolocation: Geolocation?) {
        offerRepository.getOfferMap(geolocation, { bitmap ->
            this.view?.showOfferMap(bitmap)
        })
    }
}
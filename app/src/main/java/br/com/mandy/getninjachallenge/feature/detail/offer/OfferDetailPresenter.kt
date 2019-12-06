package br.com.mandy.getninjachallenge.feature.detail.offer

import br.com.mandy.getninjachallenge.common.extension.distanceInkm
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Geolocation
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.repository.offer.OfferRepository

class OfferDetailPresenter(private val offerRepository: OfferRepository,
                           private var view: OfferDetailContract.View? = null,
                           private var offerDetail: OfferDetail? = null): OfferDetailContract.Presenter {



    override fun takeView(offerDetailView: OfferDetailContract.View) {
        this.view = offerDetailView
    }

    override fun getOfferDetail(offerDetailURL: String) {
        offerRepository.getOffersDetail(offerDetailURL, { offerDetail ->
            this.offerDetail = offerDetail
            this.view?.showOfferDetail(offerDetail)
            showMapAtView(offerDetail.embedded?.address?.geolocation)
            showDistanceAtView(offerDetail.distanceInkm)
        })
    }

    override fun acceptOffer() {
        offerRepository.getOffersDetail(offerDetail?.links?.accept?.href.orEmpty(), { offerDetail ->
            this.view?.showOfferAcceptedDetail(offerDetail)
        })
    }

    private fun showMapAtView(geolocation: Geolocation?) {
        offerRepository.getOfferMap(geolocation, { bitmap ->
            this.view?.showOfferMap(bitmap)
        })
    }

    private fun showDistanceAtView(distanceInkm: Int?) {
        this.view?.showOfferDistance(distanceInkm.toString())
    }
}
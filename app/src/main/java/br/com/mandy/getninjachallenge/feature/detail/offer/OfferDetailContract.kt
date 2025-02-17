package br.com.mandy.getninjachallenge.feature.detail.offer

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail


interface OfferDetailContract {
    interface Presenter {
        fun takeView(offerDetailView: View)
        fun getOfferDetail(offerDetailURL: String)
        fun acceptOffer()
    }

    interface View {
        fun showOfferDetail(offerDetail: OfferDetail)
        fun showOfferAcceptedDetail(offerDetail: OfferDetail)
        fun showOfferMap(map: Bitmap)
        fun showOfferDistance(distance: String)
    }
}
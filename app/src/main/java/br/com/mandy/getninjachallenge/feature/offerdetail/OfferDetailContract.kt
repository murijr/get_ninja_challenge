package br.com.mandy.getninjachallenge.feature.offerdetail

import android.graphics.Bitmap
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail


interface OfferDetailContract {
    interface Presenter {
        fun takeView(offerDetailView: View)
        fun getOfferDetail(offerDetailURL: String)
    }

    interface View {
        fun showOfferDetail(offerDetail: OfferDetail)
        fun showOfferMap(map: Bitmap)
        fun showOfferDistance(distance: String)
    }
}
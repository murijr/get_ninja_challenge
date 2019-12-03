package br.com.mandy.getninjachallenge.feature.offerdetail

interface OfferDetailContract {
    interface Presenter {
        fun takeView(offerDetailView: View)
        fun getOfferDetail(offerDetailURL: String)
    }

    interface View {
        fun showOfferDetail()
    }
}
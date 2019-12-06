package br.com.mandy.getninjachallenge.feature.offerdetail

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offers.Offer
import kotlinx.android.synthetic.main.activity_offer_detail.*
import org.koin.android.ext.android.inject

class OfferDetailActivity : AppCompatActivity(), OfferDetailContract.View {

    private val presenter: OfferDetailContract.Presenter by inject()

    private val offerDetailURL: String by lazy {
        this.intent.getStringExtra(EXTRA_OFFER_DETAIL_URL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_detail)
        setup()
    }

    private fun setup() {
        presenter.takeView(this)
        presenter.getOfferDetail(offerDetailURL)
    }

    override fun showOfferDetail(offerDetail: OfferDetail) {
        renderTitle(offerDetail.title)
    }

    override fun showOfferMap(map: Bitmap) {
        runOnUiThread { offer_map.setImageBitmap(map) }
    }

    private fun renderTitle(title: String?) {
        offer_title.text = title
    }

    companion object {
        private const val EXTRA_OFFER_DETAIL_URL = "EXTRA_OFFER_DETAIL_URL"
        fun startActivity(context: Context, offer: Offer) {
            val intent = Intent(context, OfferDetailActivity::class.java)
            intent.putExtra(EXTRA_OFFER_DETAIL_URL, offer.links?.self?.href)
            context.startActivity(intent)
        }
    }
}

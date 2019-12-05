package br.com.mandy.getninjachallenge.feature.offerdetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offers.Offer
import com.squareup.picasso.Picasso
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

        Picasso.get()
            .load("https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key=AIzaSyB9Orb1AUnAmhxWSCbaODmM7ONI1tl7BoM")
            .into(offer_map)

    }

    private fun setup() {
        presenter.takeView(this)
        presenter.getOfferDetail(offerDetailURL)
    }

    override fun showOfferDetail(offerDetail: OfferDetail) {
        return
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

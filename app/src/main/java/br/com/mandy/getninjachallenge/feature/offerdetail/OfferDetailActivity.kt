package br.com.mandy.getninjachallenge.feature.offerdetail

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Address
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail
import br.com.mandy.getninjachallenge.data.entity.offerdetail.User
import br.com.mandy.getninjachallenge.data.entity.offers.Offer
import kotlinx.android.synthetic.main.activity_offer_detail.*
import org.koin.android.ext.android.inject

class OfferDetailActivity : AppCompatActivity(), OfferDetailContract.View {

    private val presenter: OfferDetailContract.Presenter by inject()
    private val adapter: OfferDetailInfoValueAdapter by inject()

    private val offerDetailURL: String by lazy {
        this.intent.getStringExtra(EXTRA_OFFER_DETAIL_URL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_detail)
        setup()
    }

    private fun setup() {
        configureAdapter()
        presenter.takeView(this)
        presenter.getOfferDetail(offerDetailURL)
        handleUI()
    }

    private fun handleUI() {
        handleOnClickAcceptBtn()
        handleOnClickRefuseBtn()
    }

    private fun handleOnClickRefuseBtn() {
        btn_refuse.setOnClickListener { finishAfterTransition() }
    }

    private fun handleOnClickAcceptBtn() {
        btn_accept.setOnClickListener { presenter.acceptOffer() }
    }

    private fun configureAdapter() {
        offer_detail_list.isNestedScrollingEnabled = false
        offer_detail_list.adapter = adapter
        offer_detail_list.layoutManager = LinearLayoutManager(this)
    }

    override fun showOfferDetail(offerDetail: OfferDetail) {
        displayTitle(offerDetail.title)
        displayName(offerDetail.embedded?.user?.name)
        displayAddress(offerDetail.embedded?.address)
        displayOfferInfo(offerDetail.embedded?.info)
        displayUserInfo(offerDetail.embedded?.user)
    }

    override fun showOfferAcceptedDetail(offerDetail: OfferDetail) {
        showOfferDetail(offerDetail)
        applyChangesOfferAccepted(offerDetail)
    }

    private fun applyChangesOfferAccepted(offerDetail: OfferDetail) {
        adapter.updateData(offerDetail.embedded?.info.orEmpty(), true)
        view.setBackgroundColor(getColor(R.color.green_client_accepted_color))
        text_label_client_info.setTextColor(getColor(android.R.color.black))
        offer_detail_tel.setTextColor(getColor(android.R.color.black))
        offer_detail_email.setTextColor(getColor(android.R.color.black))
        tel_lock.setImageDrawable(getDrawable(R.drawable.ic_local_phone_black_24dp))
        email_lock.setImageDrawable(getDrawable(R.drawable.ic_email_black_24dp))
        icon_name.setImageDrawable(getDrawable(R.drawable.ic_person_green_24dp))
        icon_place3.setImageDrawable(getDrawable(R.drawable.ic_place_green_24dp))
        text_msg.text = getString(R.string.talk_client)
    }

    private fun displayUserInfo(user: User?) {
        offer_detail_email.text = user?.email
        offer_detail_tel.text = user?.embedded?.phones?.first()?.number
    }

    override fun showOfferMap(map: Bitmap) {
        runOnUiThread { offer_map.setImageBitmap(map) }
    }

    override fun showOfferDistance(distance: String) {
        runOnUiThread { offer_distance.text = String.format(getString(R.string.text_distance_km), distance) }
    }

    private fun displayTitle(title: String?) {
        offer_title.text = title
    }

    private fun displayAddress(address: Address?) {
        offer_address.text = String.format(getString(R.string.text_address), address?.neighborhood, address?.city)
    }

    private fun displayName(name: String?) {
        offer_name.text = name
    }

    private fun displayOfferInfo(info: List<Info>?) {
        adapter.updateData(info.orEmpty())
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
